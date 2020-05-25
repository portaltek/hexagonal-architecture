package portaltek.hexa.spi.repo.repo;

import org.springframework.data.repository.CrudRepository;
import portaltek.hexa.spi.repo.entities.Catalog;

public interface CatalogRepo extends CrudRepository<Catalog, Long> {

    Catalog findById(long id);
}