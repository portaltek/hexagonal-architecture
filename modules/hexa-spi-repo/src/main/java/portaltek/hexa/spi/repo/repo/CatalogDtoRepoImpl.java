package portaltek.hexa.spi.repo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import portaltek.hexa.domain.dto.catalog.CatalogDto;
import portaltek.hexa.spi.repo.CatalogDtoRepo;
import portaltek.hexa.spi.repo.converter.RepoToDtoCatalogConverter;
import portaltek.hexa.spi.repo.dao.CatalogDao;
import portaltek.hexa.spi.repo.entities.Catalog;

@Repository
public class CatalogDtoRepoImpl implements CatalogDtoRepo {

    @Autowired
    CatalogDao catalogDao;
    @Autowired
    RepoToDtoCatalogConverter converter;

    public CatalogDto findByCompanyIdAndFiscalPeriodId(Long companyId, Long fiscalPeriodId) {
        Catalog catalog = catalogDao.findByCompanyIdAndFiscalPeriodId(companyId, fiscalPeriodId);
        return converter.from(catalog);
    }
}
