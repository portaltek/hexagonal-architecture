package portaltek.hexa.spi.repo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import portaltek.hexa.spi.repo.entities.Catalog;
import portaltek.hexa.spi.repo.repo.CatalogDao;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
public class IT_CatalogDao {
	static Logger log = LoggerFactory.getLogger(IT_CatalogDao.class);

	@Autowired
    private CatalogDao repo;

	@Test
	void save() {

		log.info("AppIntegrationTest.contextLoads");

		repo.save(new Catalog().id(1L));
		repo.save(new Catalog().id(2L));

		List<Catalog> catalogs = (List<Catalog>) repo.findAll();
		assertEquals(2, catalogs.size());
	}



}
