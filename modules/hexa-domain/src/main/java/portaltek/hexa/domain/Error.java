package portaltek.hexa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import portaltek.hexa.domain.enums.ErrorType;

@Data
@AllArgsConstructor
@Accessors(fluent = true)
public class Error {

    private ErrorType errorType;
    private String msg;

    public String toString() {
        if (StringUtils.isEmpty(msg)) {
            return "" + errorType + "";
        }
        return "" + errorType + ":" + msg + "";
    }

}
