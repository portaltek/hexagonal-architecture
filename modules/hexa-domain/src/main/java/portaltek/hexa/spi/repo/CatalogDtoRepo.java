package portaltek.hexa.spi.repo;


import portaltek.hexa.domain.dto.catalog.CatalogDto;

public interface CatalogDtoRepo {

    CatalogDto findByCompanyIdAndFiscalPeriodId(Long companyId, Long fiscalPeriodId);
}
