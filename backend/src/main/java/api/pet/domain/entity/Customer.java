package api.pet.domain.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer extends User {

    private String cpf;
    private String historyOrders;
    //TODO implementer myPaymentsMethods
    //TODO implementer myPets

}
