package api.pet.service;

import api.pet.domain.dto.UserDTO;
import api.pet.domain.entity.Role;
import api.pet.domain.entity.User;
import api.pet.domain.enums.RoleEnum;
import api.pet.domain.enums.UserTypeEnum;
import api.pet.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class RoleService {

    private final RoleRepository roleRepository;

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
