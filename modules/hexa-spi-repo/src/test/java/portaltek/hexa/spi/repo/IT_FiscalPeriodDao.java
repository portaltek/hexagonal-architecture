package portaltek.hexa.spi.repo;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import portaltek.hexa.spi.repo.entities.FiscalPeriod;
import portaltek.hexa.spi.repo.dao.FiscalPeriodDao;

import static org.junit.Assert.assertNotNull;

@Slf4j
@SpringBootTest
class IT_FiscalPeriodDao {

	@Autowired
    private FiscalPeriodDao dao;

	@Test
	void save() {
		FiscalPeriod fp = _TestUtil_CatalogBuilder.getValidFiscalPeriod(1L);
		fp.id(null);
		dao.save(fp);
		assertNotNull(fp.id());
	}



}
