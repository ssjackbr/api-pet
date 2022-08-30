package api.pet.domain.dto;

import api.pet.domain.entity.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserInsertDTO extends User {

    private String password;
}
