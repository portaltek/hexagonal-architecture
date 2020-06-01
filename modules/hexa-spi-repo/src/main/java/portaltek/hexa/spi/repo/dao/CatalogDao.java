package portaltek.hexa.spi.repo.dao;

import org.springframework.data.repository.CrudRepository;
import portaltek.hexa.spi.repo.entities.Catalog;


public interface CatalogDao extends CrudRepository<Catalog, Long> {


}