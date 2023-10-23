package api.pet.service;

import api.pet.domain.dto.UserDTO;
import api.pet.domain.dto.UserRegisteredDTO;
import api.pet.domain.dto.UserUpdateDTO;
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
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final AddressMapper addressMapper;
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRegisteredDTO registrationUser(UserDTO userDTO){

        User userInDataBase = userRepository.findByEmail(userDTO.getEmail());

        if(Objects.isNull(userInDataBase)){

            userDTO.setCreateAt(Instant.now());
            userDTO.setActive(true);
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));

            User userToSave = userMapper.convertUserDTOToUserEntity(userDTO);
            User newUser = userRepository.save(userToSave);

            roleService.validateAndApplyRoles(userDTO, newUser);

            userDTO.getAddress().forEach(addressDTO -> {
                Address addressToSave = addressMapper.convertAddressDTOToAddressEntity(addressDTO);
                addressToSave.setUser(newUser);
                addressRepository.save(addressToSave);
            });

            UserRegisteredDTO userRegisteredDTO =  userMapper.convertUserDTOToUserRegisteredDTO(userDTO);
            userRegisteredDTO.setCreateAt(UserRegisteredDTO.formatterInstantDate(userDTO.getCreateAt()));

            return userRegisteredDTO;
        }
        //TODO Refactor with custom Exception message
        else throw new RuntimeException("ERROR: User "+userDTO.getEmail()+" already exists!");
    }

    public UserRegisteredDTO findUserByEmail(String email) {

        User user = Optional.ofNullable(userRepository.findByEmail(email)).orElse(null);

        if(Objects.isNull(user)){
            //TODO Implements custom exception
            throw new RuntimeException("@@@ ERROR USER "+email+" NOT FOUND! @@@");
        }

        UserRegisteredDTO userRegisteredDTO =  userMapper.convertUserToUserRegisteredDTO(user);
        userRegisteredDTO.setCreateAt(UserRegisteredDTO.formatterInstantDate(user.getCreateAt()));
        return userRegisteredDTO;
    }

    public UserRegisteredDTO updateUser(UserUpdateDTO userUpdateDTO) {

        return null;
    }
}
