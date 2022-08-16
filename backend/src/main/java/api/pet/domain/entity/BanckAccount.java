package api.pet.domain.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class BanckAccount {

    private Long id;
    private String bank;
    private String agency;
    private String account;
    private String pixKey;
}
