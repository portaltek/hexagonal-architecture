package portaltek.hexa.domain.dto.catalog;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(fluent = true)
public class CompanyDto {

    private Long id;
    private String code;
    private String name;
    private String description;

}
