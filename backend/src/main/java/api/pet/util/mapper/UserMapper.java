package api.pet.util.mapper;

import api.pet.domain.dto.UserDTO;
import api.pet.domain.dto.UserRegisteredDTO;
import api.pet.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Optional;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "updateAt", source = "dto.updateAt")
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "personalContact", source = "dto.personalContact")
    @Mapping(target = "workContact", source = "dto.workContact")
    @Mapping(target = "email", source = "dto.email")
    @Mapping(target = "password", source = "dto.password")
    @Mapping(target = "pictureUrl", source = "dto.pictureUrl")
    @Mapping(target = "iconUrl", source = "dto.iconUrl")
    @Mapping(target = "active", source = "dto.active")
    @Mapping(target = "createAt", source = "dto.createAt")
    @Mapping(target = "cnpj", source = "dto.cnpj")
    @Mapping(target = "cpf", source = "dto.cpf")
    @Mapping(target = "socialReason", source = "dto.socialReason")
    @Mapping(target = "stateRegistration", source = "dto.stateRegistration")
    @Mapping(target = "fantasyName", source = "dto.fantasyName")
    @Mapping(target = "userTypeEnum", source = "dto.userTypeEnum")
    User convertUserDTOToUserEntity (UserDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", source = "dto.address")
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "personalContact", source = "dto.personalContact")
    @Mapping(target = "workContact", source = "dto.workContact")
    @Mapping(target = "email", source = "dto.email")
    @Mapping(target = "active", source = "dto.active")
    @Mapping(target = "createAt", source = "dto.createAt")
    @Mapping(target = "cnpj", source = "dto.cnpj")
    @Mapping(target = "cpf", source = "dto.cpf")
    @Mapping(target = "socialReason", source = "dto.socialReason")
    @Mapping(target = "stateRegistration", source = "dto.stateRegistration")
    @Mapping(target = "fantasyName", source = "dto.fantasyName")
    @Mapping(target = "userTypeEnum", source = "dto.userTypeEnum")
    UserRegisteredDTO convertUserDTOToUserRegisteredDTO (UserDTO dto);

    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "address", source = "user.address")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "personalContact", source = "user.personalContact")
    @Mapping(target = "workContact", source = "user.workContact")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "active", source = "user.active")
    @Mapping(target = "createAt", source = "user.createAt")
    @Mapping(target = "cnpj", source = "user.cnpj")
    @Mapping(target = "cpf", source = "user.cpf")
    @Mapping(target = "socialReason", source = "user.socialReason")
    @Mapping(target = "stateRegistration", source = "user.stateRegistration")
    @Mapping(target = "fantasyName", source = "user.fantasyName")
    @Mapping(target = "userTypeEnum", source = "user.userTypeEnum")
    UserRegisteredDTO convertUserToUserRegisteredDTO (User user);

}
