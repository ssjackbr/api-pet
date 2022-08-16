package api.pet.domain.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Score {

    private Long id;
    private User evaluatorUser;
    private Double value;
    private String comment;
}
