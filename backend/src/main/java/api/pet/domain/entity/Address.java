package api.pet.domain.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Address {

    private Long id;
    private String street;
    private String number;
    private String districtArea;
    private String complement;
    private String referencePoint;
    private String city;
    private String state;
    private String country;
    private String CEP;
}
