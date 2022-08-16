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
public class Client extends User {

    private Long id;
    private List<Address> myAddress;
    // implementar myPaymentsMethods
    // implementar myPets

}
