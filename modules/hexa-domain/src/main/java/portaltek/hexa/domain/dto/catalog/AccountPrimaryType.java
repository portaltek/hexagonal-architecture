package portaltek.hexa.domain.dto.catalog;

import java.util.Arrays;


public enum AccountPrimaryType {

    ACTIVE("100-0000-0000"),
    PASIVE("200-0000-0000"),
    CAPITAL("300-0000-0000"),
    REVENOU("400-0000-0000"),
    EXPENSES("500-0000-0000"),
    ;
    private String code;

    AccountPrimaryType(String code) {
        this.code = code;
    }



    public AccountPrimaryType findByCode(String code) {

        return Arrays.stream(values())
                .filter(i -> i.getCode() == code)
                .findFirst()
                .orElseThrow(()->new RuntimeException());

    }

    public String getCode() {
        return code;
    }

    public AccountPrimaryType setCode(String code) {
        this.code = code;
        return this;
    }
}
