package api.pet.service;

import api.pet.config.SecurityConfig;
import api.pet.domain.dto.UserDTO;
import api.pet.domain.dto.UserInsertDTO;
import api.pet.domain.dto.UserRegisteredDTO;
import api.pet.domain.entity.Address;
import api.pet.domain.entity.User;
import api.pet.repository.AddressRepository;
import api.pet.repository.UserRepository;
import api.pet.util.mapper.AddressMapper;
import api.pet.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections4.functors.CatchAndRethrowClosure;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final AddressMapper addressMapper;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public UserRegisteredDTO registrationConsumerUser(UserDTO userDTO){

        userDTO.setCreateAt(Instant.now());
        userDTO.setActive(true);
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User userToSave = userMapper.convertUserDTOToUserEntity(userDTO);

        User userInDataBase = userRepository.findByEmail(userDTO.getEmail());

        if(Objects.isNull(userInDataBase)){

            User newUser = userRepository.save(userToSave);
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
        else throw new RuntimeException("Error user "+userDTO.getEmail()+" already exists!");

    }
    public void registrationPartnerUser(UserDTO userDTO){

    }

}
