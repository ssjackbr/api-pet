package api.pet.domain.dto;

import api.pet.domain.enums.UserTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.Instant;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegisteredDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String personalContact;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean active;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createAt;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cnpj;

    @JsonInclude(JsonInclude.Include.NON_NULL)
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
}
