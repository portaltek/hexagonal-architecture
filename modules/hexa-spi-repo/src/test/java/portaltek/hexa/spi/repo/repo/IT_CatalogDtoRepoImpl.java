package portaltek.hexa.spi.repo.repo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import portaltek.hexa.domain.dto.catalog.CatalogDto;
import portaltek.hexa.spi.repo.CatalogDtoRepo;
import portaltek.hexa.spi.repo.converter.RepoToDtoCatalogConverter;
import portaltek.hexa.spi.repo.dao.CatalogDao;
import portaltek.hexa.spi.repo.dao.CompanyDao;
import portaltek.hexa.spi.repo.dao.FiscalPeriodDao;
import portaltek.hexa.spi.repo.entities.Catalog;
import portaltek.hexa.spi.repo.entities.Company;
import portaltek.hexa.spi.repo.entities.FiscalPeriod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static portaltek.hexa.spi.repo._TestUtil_CatalogBuilder.*;


@Slf4j
@SpringBootTest
class IT_CatalogDtoRepoImpl {

    @Autowired
    private CatalogDao catalogDao;
    @Autowired
    private FiscalPeriodDao fiscalPeriodDao;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    RepoToDtoCatalogConverter converter;
    @Autowired
    private CatalogDtoRepo repo;

    @BeforeEach
    void init() {
        FiscalPeriod fiscalPeriod = fiscalPeriodDao.save(getValidFiscalPeriod(1L));
        Company company = companyDao.save(getValidCompany(1L));
        Catalog catalog1 = getValidCatalog(1L, 3L).id(null)
                .company(company)
                .fiscalPeriod(fiscalPeriod)
                .accounts(null);
        catalogDao.save(catalog1);
    }

    @Test
    void findByCompanyIdAndFiscalPeriodId() {

        CatalogDto dto = repo.findByCompanyIdAndFiscalPeriodId(2L, 1L);

        assertNotNull(dto);
        assertEquals(3L, dto.id());
    }


}