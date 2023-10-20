package api.pet.domain.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {

    private String addressName;
    private String street;
    private String number;
    private String districtArea;
    private String complement;
    private String referencePoint;
    private String city;
    private String state;
    private String country;
    private String cep;
}
