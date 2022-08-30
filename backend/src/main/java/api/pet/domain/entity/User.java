package api.pet.domain.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

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
    private String password;
    private String cpf;
    private String cnpj;
    private String pictureUrl;
    private String iconUrl;
    private List<Address> addressList;
}
