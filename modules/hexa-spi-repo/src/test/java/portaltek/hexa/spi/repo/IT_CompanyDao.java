package portaltek.hexa.spi.repo;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import portaltek.hexa.spi.repo.entities.Company;
import portaltek.hexa.spi.repo.repo.CompanyDao;

import static org.junit.Assert.assertNotNull;

@Slf4j
@SpringBootTest
class IT_CompanyDao {

	@Autowired
    private CompanyDao dao;

	@Test
	void save() {
		Company company = _TestUtil_CatalogBuilder.getValidCompany(1L).id(null);
		dao.save(company);
		assertNotNull(company.id());
	}



}
