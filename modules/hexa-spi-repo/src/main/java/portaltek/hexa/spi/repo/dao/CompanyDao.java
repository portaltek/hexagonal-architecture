package portaltek.hexa.spi.repo.dao;

import org.springframework.data.repository.CrudRepository;
import portaltek.hexa.spi.repo.entities.Company;


public interface CompanyDao extends CrudRepository<Company, Long> {


}