package portaltek.hexa.domain.dto.catalog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Collection;
import java.util.List;
import java.util.Set;

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
