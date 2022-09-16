package api.pet.util.mapper;

import api.pet.domain.dto.RoleDTO;
import api.pet.domain.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface RoleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "role", source = "dto.role")
    Role convertDtoToRoleEntity(RoleDTO dto);

    @Mapping(target = "role", source = "role.role")
    RoleDTO convertEntityRoleToDTO(Role role);

}
