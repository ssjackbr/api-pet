package api.pet.domain.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class SocialMidea {

    private Long id;
    private String instagram;
    private String facebook;
    private String linkedin;
    private String youTube;
    private String site;
}
