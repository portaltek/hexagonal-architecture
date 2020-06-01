package portaltek.hexa.spi.repo;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import portaltek.hexa.spi.repo.entities.Catalog;
import portaltek.hexa.spi.repo.entities.Company;
import portaltek.hexa.spi.repo.entities.FiscalPeriod;
import portaltek.hexa.spi.repo.dao.CatalogDao;
import portaltek.hexa.spi.repo.dao.CompanyDao;
import portaltek.hexa.spi.repo.dao.FiscalPeriodDao;

import static org.junit.Assert.assertNotNull;
import static portaltek.hexa.spi.repo._TestUtil_CatalogBuilder.*;

@Slf4j
@SpringBootTest
class IT_CatalogDao {

	@Autowired
    private CatalogDao dao;
	@Autowired
	private FiscalPeriodDao fiscalPeriodDao;
	@Autowired
	private CompanyDao companyDao;

	@BeforeEach
	void init(){

	}

	@Test
	void save() {
		FiscalPeriod fiscalPeriod = fiscalPeriodDao.save(getValidFiscalPeriod(1L));
		Company company = companyDao.save(getValidCompany(1L));
		Catalog catalog1 = getValidCatalog(1L, 3L).id(null)
				.company(company)
				.fiscalPeriod(fiscalPeriod)
				.accounts(null);
		dao.save(catalog1);

		assertNotNull(catalog1.id());
	}



}
