package portaltek.hexa.domain.dto.catalog;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(fluent = true)
@NoArgsConstructor
public class FiscalPeriodDto {

    private Long id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;

}
