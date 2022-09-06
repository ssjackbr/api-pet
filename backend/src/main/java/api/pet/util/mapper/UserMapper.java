package api.pet.util.mapper;

import api.pet.domain.dto.UserDTO;
import api.pet.domain.dto.UserInsertDTO;
import api.pet.domain.entity.Address;
import api.pet.domain.entity.Customer;
import api.pet.domain.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "adresses", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "historyOrders", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    @Mapping(target = "firstName", source = "dto.firstName")
    @Mapping(target = "lastName", source = "dto.lastName")
    @Mapping(target = "mobilePhone", source = "dto.mobilePhone")
    @Mapping(target = "email", source = "dto.email")
    @Mapping(target = "password", source = "dtoPassword.password")
    @Mapping(target = "pictureUrl", source = "dto.pictureUrl")
    @Mapping(target = "iconUrl", source = "dto.iconUrl")
    @Mapping(target = "enable", source = "dto.enable")
    @Mapping(target = "createAt", source = "dto.createAt")
    @Mapping(target = "cpf", source = "dto.cpf")
    Customer convertDtoToCustomerEntity (UserDTO dto, UserInsertDTO dtoPassword);


    @Mapping(target = "password", ignore = true)
    @Mapping(target = "roles",source = "roles")
    @Mapping(target = "adresses",source = "adresses")
    @Mapping(target = "firstName", source = "customer.firstName")
    @Mapping(target = "lastName", source = "customer.lastName")
    @Mapping(target = "mobilePhone", source = "customer.mobilePhone")
    @Mapping(target = "email", source = "customer.email")
    @Mapping(target = "pictureUrl", source = "customer.pictureUrl")
    @Mapping(target = "iconUrl", source = "customer.iconUrl")
    @Mapping(target = "enable", source = "customer.enable")
    @Mapping(target = "createAt", source = "customer.createAt")
    @Mapping(target = "updateAt", source = "customer.updateAt")
    UserDTO convertEntityCustomerToDTO (Customer customer, Set<Address> adresses, Set<Role> roles);

}
