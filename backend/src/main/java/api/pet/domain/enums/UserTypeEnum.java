package api.pet.domain.enums;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum UserTypeEnum {

    PARTNER("partner"),
    CONSUMER("consumer");

    private final String key;

    public static UserTypeEnum fromKey(@NotNull String pKey) {
        return Arrays.stream(UserTypeEnum.values()).filter(pUserTypeEnum -> pUserTypeEnum.getKey().equals(pKey))
                .findFirst().orElseThrow();
    }
}
