package portaltek.hexa.spi.repo;


import portaltek.hexa.domain.dto.catalog.Catalog;

public interface CatalogRepo {
    Catalog findById(String id);

    Catalog findBy(Catalog catalog);

    Catalog save(Catalog catalog);

    Catalog findByCompanyIdAndFiscalPeriodId(Long companyId, Long fiscalPeriodId);
}
