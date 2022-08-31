package api.pet.domain.enums;

import lombok.Getter;

@Getter
public final class Roles {
    private Roles(){
    }

    public static final String ADMIN = "admin";
    public static final String SUPPORT = "support";
    public static final String PARTNER = "partner";
    public static final String CUSTOMER = "customer";
}
