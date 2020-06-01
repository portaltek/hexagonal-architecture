package portaltek.hexa.domain.dto.catalog;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Collection;

@Data
@Accessors(fluent = true)
@NoArgsConstructor
public class CatalogDto {

    private Long id;
    private CompanyDto companyDto;
    private FiscalPeriodDto fiscalPeriodDto;
    private Collection<AccountDto> accountDtos;
    private Boolean valid;



}
