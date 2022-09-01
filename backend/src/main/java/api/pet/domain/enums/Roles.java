package api.pet.domain.enums;

import lombok.*;

@Builder
@Setter
@Getter
public final class Roles {
    private Roles(){
    }

    public static final String ADMIN    = "ROLE_ADMIN";
    public static final String USER     = "ROLE_USER";
    public static final String SUPPORT  = "ROLE_SUPPORT";
    public static final String PARTNER  = "ROLE_PARTNER";
    public static final String CUSTOMER = "ROLE_CUSTOMER";
}
