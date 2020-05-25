package portaltek.hexa.domain.dto.catalog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(fluent = true)
@AllArgsConstructor
public class Account {

    private Long id;
    private String code;
    private String name;
    private String description;
    private Catalog catalog;




}