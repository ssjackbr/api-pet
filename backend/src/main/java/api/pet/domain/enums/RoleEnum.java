package api.pet.domain.enums;

import lombok.*;

@RequiredArgsConstructor
@Getter
public enum RoleEnum {

    ADMIN("admin"),
    USER("user"),
    SUPPORT("support"),
    PARTNER("partner"),
    CONSUMER("consumer");

    private final String key;
}
