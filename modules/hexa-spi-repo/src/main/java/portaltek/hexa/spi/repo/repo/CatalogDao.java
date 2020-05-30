package portaltek.hexa.spi.repo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import portaltek.hexa.spi.repo.entities.Catalog;

@Repository
public interface CatalogDao extends CrudRepository<Catalog, Long> {


}