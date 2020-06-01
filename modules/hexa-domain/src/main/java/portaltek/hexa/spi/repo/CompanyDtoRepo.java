package portaltek.hexa.spi.repo;

import portaltek.hexa.domain.dto.catalog.CatalogDto;
import portaltek.hexa.domain.dto.catalog.CompanyDto;

public interface CompanyDtoRepo {
    CompanyDto findById(Long id);
    CompanyDto findByName(String name);
    CatalogDto findByCompanyIdAndFiscalPeriodId(Long companyId, Long fiscalPeriodId);
}
