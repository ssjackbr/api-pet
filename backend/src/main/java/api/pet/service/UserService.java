package api.pet.service;

import api.pet.domain.dto.UserDTO;
import api.pet.domain.dto.UserRegisteredDTO;
import api.pet.domain.entity.Address;
import api.pet.domain.entity.Role;
import api.pet.domain.entity.User;
import api.pet.domain.enums.RoleEnum;
import api.pet.domain.enums.UserTypeEnum;
import api.pet.repository.AddressRepository;
import api.pet.repository.RoleRepository;
import api.pet.repository.UserRepository;
import api.pet.util.mapper.AddressMapper;
import api.pet.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final AddressMapper addressMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRegisteredDTO registrationConsumerUser(UserDTO userDTO){

        User userInDataBase = userRepository.findByEmail(userDTO.getEmail());

        if(Objects.isNull(userInDataBase)){

            userDTO.setCreateAt(Instant.now());
            userDTO.setActive(true);
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));

            User userToSave = userMapper.convertUserDTOToUserEntity(userDTO);
            User newUser = userRepository.save(userToSave);

            validateAndApplyRoles(userDTO, newUser);

            userDTO.getAddress().forEach(addressDTO -> {
                Address addressToSave = addressMapper.convertAddressDTOToAddressEntity(addressDTO);
                addressToSave.setUser(newUser);
                addressRepository.save(addressToSave);
            });

            UserRegisteredDTO userRegisteredDTO =  userMapper.convertUserDTOToUserRegisteredDTO(userDTO);
            userRegisteredDTO.setCreateAt(Instant.parse(userDTO.getCreateAt().toString())
                    .atZone(ZoneId.of("UTC"))
                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

            return userRegisteredDTO;
        }
        //TODO Refactor with custom Exception message
        else throw new RuntimeException("Error user "+userDTO.getEmail()+" already exists!");

    }
    public void registrationPartnerUser(UserDTO userDTO){

    }

    public void validateAndApplyRoles(UserDTO userDTO, User user){

        List<Role> roleList = new ArrayList<>();

        if (Objects.nonNull(userDTO) && userDTO.getUserTypeEnum().getKey().equals(UserTypeEnum.CONSUMER.getKey())){
            roleList.add(Role.builder()
                    .user(user)
                    .role(RoleEnum.CONSUMER)
                    .build());

            roleList.add(Role.builder()
                    .user(user)
                    .role(RoleEnum.USER)
                    .build());

            roleRepository.saveAll(roleList);
        }

        if (Objects.nonNull(userDTO) && userDTO.getUserTypeEnum().getKey().equals(UserTypeEnum.PARTNER.getKey())){
            roleList.add(Role.builder()
                    .user(user)
                    .role(RoleEnum.PARTNER)
                    .build());

            roleList.add(Role.builder()
                    .user(user)
                    .role(RoleEnum.USER)
                    .build());

        } roleRepository.saveAll(roleList);
    }

}
