package portaltek.hexa.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HexaUser {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String lastName;

}
