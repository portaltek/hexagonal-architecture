package portaltek.hexa.domain.dto.catalog;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@NoArgsConstructor
public class CompanyDto {

    private Long id;
    private String code;
    private String name;
    private String description;

}
