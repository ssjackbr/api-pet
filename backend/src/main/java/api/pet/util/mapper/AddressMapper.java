package api.pet.util.mapper;

import api.pet.domain.dto.AddressDTO;
import api.pet.domain.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "cep", source = "dto.cep")
    @Mapping(target = "country", source = "dto.country")
    @Mapping(target = "state", source = "dto.state")
    @Mapping(target = "city", source = "dto.city")
    @Mapping(target = "referencePoint", source = "dto.referencePoint")
    @Mapping(target = "complement", source = "dto.complement")
    @Mapping(target = "districtArea", source = "dto.districtArea")
    @Mapping(target = "number", source = "dto.number")
    @Mapping(target = "street", source = "dto.street")
    @Mapping(target = "addressName", source = "dto.addressName")
    Address convertAddressDTOToAddressEntity (AddressDTO dto);

    @Mapping(target = "cep", source = "address.cep")
    @Mapping(target = "country", source = "address.country")
    @Mapping(target = "state", source = "address.state")
    @Mapping(target = "city", source = "address.city")
    @Mapping(target = "referencePoint", source = "address.referencePoint")
    @Mapping(target = "complement", source = "address.complement")
    @Mapping(target = "districtArea", source = "address.districtArea")
    @Mapping(target = "number", source = "address.number")
    @Mapping(target = "street", source = "address.street")
    @Mapping(target = "addressName", source = "address.addressName")
    AddressDTO convertAddressEntityToAddressToDTO (Address address);

}
