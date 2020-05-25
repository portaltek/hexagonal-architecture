package portaltek.hexa.spi.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import portaltek.hexa.spi.repo.entities.Catalog;
import portaltek.hexa.spi.repo.repo.CatalogRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AppIntegrationTest {

	@Autowired
	CatalogRepo repo;

	@Test
	void contextLoads() {
		System.out.println("AppIntegrationTest.contextLoads");
		repo.save(new Catalog().id(1L));
		repo.save(new Catalog().id(2L));

		List<Catalog> catalogs = (List<Catalog>) repo.findAll();
		assertEquals(2, catalogs.size());
	}

}
