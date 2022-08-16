package api.pet.domain.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder
public class Partner extends User{

    private Long id;
    private String socialReason;
    private String stateRegistration;
    private String fantasyName;
    private String professionalPhone;
    private Score score;
    private BanckAccount banckAccount;
    private SocialMidea socialMidea;
}
