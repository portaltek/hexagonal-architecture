package portaltek.hexa.spi.repo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import portaltek.hexa.spi.repo.entities.Catalog;


public interface CatalogDao extends CrudRepository<Catalog, Long> {

    @Query(name = "Catalog.findByCompanyIdAndFiscalPeriodId")
    Catalog findByCompanyIdAndFiscalPeriodId(Long companyId, Long fiscalPeriodId);

}