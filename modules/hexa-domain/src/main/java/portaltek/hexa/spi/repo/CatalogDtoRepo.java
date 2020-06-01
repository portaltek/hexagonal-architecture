package portaltek.hexa.spi.repo;


import portaltek.hexa.domain.dto.catalog.CatalogDto;

public interface CatalogDtoRepo {
    CatalogDto findById(String id);

    CatalogDto findBy(CatalogDto catalogDto);

    CatalogDto save(CatalogDto catalogDto);

    CatalogDto findByCompanyIdAndFiscalPeriodId(Long companyId, Long fiscalPeriodId);
}
