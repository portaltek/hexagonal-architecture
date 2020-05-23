package portaltek.hexa.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import portaltek.hexa.domain.enums.ErrorType;
import portaltek.hexa.domain.enums.UseCaseType;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = false)
public class HexaException extends Exception {

    private final UseCaseType type;
    private List<Error> errors = new ArrayList<>();

    private HexaException(UseCaseType type){
        this.type = type;
    }

    public static HexaException of(UseCaseType type){
        return new HexaException(type);
    }


    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    public HexaException add(ErrorType errorType,
                             String msg){
        this.errors.add(new Error(errorType, msg));
        return this;
    }

    public HexaException add(ErrorType errorType){
        return this.add(errorType, "");
    }


}
