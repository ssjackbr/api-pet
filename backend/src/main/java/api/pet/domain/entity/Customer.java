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
public class Customer extends User {

    private Long id;
    private List<Address> myAddress;
    //TODO implementer myPaymentsMethods
    //TODO implementer myPets

}
