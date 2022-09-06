package api.pet.domain.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@RequiredArgsConstructor
@SuperBuilder
@Entity
@Table(name = "partner")
public class Partner extends User{

    private String cnpj;
    private String socialReason;
    private String stateRegistration;
    private String fantasyName;
    private String mobilePhone;

    //TODO private Rating rating;
    //TODO private BanckAccount banckAccount;
    //TODO private SocialMidea socialMidea;*/

}
