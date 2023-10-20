package api.pet.domain.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInsertDTO extends UserDTO {

    private String password;
}
