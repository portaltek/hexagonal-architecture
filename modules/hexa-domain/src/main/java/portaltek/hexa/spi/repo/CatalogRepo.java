package portaltek.hexa.spi.repo;


import portaltek.hexa.domain.dto.catalog.Catalog;
import portaltek.hexa.domain.dto.catalog.Company;
import portaltek.hexa.domain.dto.catalog.FiscalPeriod;

public interface CatalogRepo {
    Catalog findById(String id);

    Catalog findBy(Company company, FiscalPeriod fiscalPeriod);

    Catalog findByCompanyIdAndFiscalPeriodId(Long companyId, Long fiscalPeriodId);

    Catalog findBy(Catalog catalog);

    Catalog save(Catalog catalog);
}
