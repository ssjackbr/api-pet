package api.pet.domain.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserDTO {

    private String firstName;
    private String lastName;
    private String mobilePhone;
    private String email;
    private String pictureUrl;
    private String iconUrl;
    private Boolean enable;
    private Instant createAt;
    private Instant updateAt;
    private String cpf;
    private Set<AddressDTO> adresses;
    private Set<RoleDTO> roles;

}
