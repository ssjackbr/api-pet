package api.pet.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;
@Builder
@Getter
@AllArgsConstructor
public class UserUpdateDTO {

    private String name;
    private String email;
    private String personalContact;
    private String workContact;
    private String fantasyName;
    private Set<AddressDTO> address;
}
