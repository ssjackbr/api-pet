package api.pet.util.mapper;

import api.pet.domain.dto.UserDTO;
import api.pet.domain.dto.UserRegisteredDTO;
import api.pet.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

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
}
