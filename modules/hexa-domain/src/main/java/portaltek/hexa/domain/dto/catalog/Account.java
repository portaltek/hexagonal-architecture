package portaltek.hexa.domain.dto.catalog;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;

@Data
@Builder
@Accessors(fluent = true)
public class Account {

    private Long id;
    private String code;
    private String name;
    private String description;
    private Catalog catalog;


}
