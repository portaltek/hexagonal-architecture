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
public class CatalogDto {

    private CompanyDto companyDto;
    private FiscalPeriodDto fiscalPeriodDto;
    private Collection<AccountDto> accountDtos;
    private Boolean valid;



}
