package portaltek.hexa.domain.dto.catalog;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Builder
@Accessors(fluent = true)
public class FiscalPeriod {

    private Long id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;

}
