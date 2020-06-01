package portaltek.hexa.spi.repo;

import portaltek.hexa.domain.dto.catalog.Catalog;
import portaltek.hexa.domain.dto.catalog.Company;

public interface CompanyRepo  {
    Company findById(Long id);
    Company findByName(String name);
    Catalog findByCompanyIdAndFiscalPeriodId(Long companyId, Long fiscalPeriodId);
}
