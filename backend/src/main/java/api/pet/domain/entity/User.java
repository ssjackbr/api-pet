package api.pet.domain.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String mobilePhone;
    private String email;
    private String cpf;
    private String cnpj;
    private String pictureUrl;
    private String iconUrl;
    private Address address;
}
