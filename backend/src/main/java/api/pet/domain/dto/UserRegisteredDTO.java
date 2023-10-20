package api.pet.domain.dto;

import api.pet.domain.enums.UserTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisteredDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String personalContact;

    private String email;
    private Boolean active;
    private String createAt;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cnpj;

    private String cpf;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String socialReason;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String stateRegistration;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fantasyName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String workContact;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Enumerated(EnumType.STRING)
    private UserTypeEnum userTypeEnum;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<AddressDTO> address;

    public static String formatterInstantDate(Instant instantDate){

        return Instant.parse(instantDate.toString())
                .atZone(ZoneId.of("UTC"))
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

    }
}
