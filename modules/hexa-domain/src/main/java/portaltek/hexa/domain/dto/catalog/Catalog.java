package portaltek.hexa.domain.dto.catalog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Collection;

@Data
@Builder
@Accessors(fluent = true)
@AllArgsConstructor
public class Catalog {

    private Company company;
    private FiscalPeriod fiscalPeriod;
    private Collection<Account> accounts;
    private Boolean valid;



}
