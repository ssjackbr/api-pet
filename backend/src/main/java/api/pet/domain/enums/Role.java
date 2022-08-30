package api.pet.domain.enums;

import lombok.Getter;

@Getter
public final class Role {
    private Role(){
    }

    public static final String ADMIN = "admin";
    public static final String OPERATOR = "operator";
}
