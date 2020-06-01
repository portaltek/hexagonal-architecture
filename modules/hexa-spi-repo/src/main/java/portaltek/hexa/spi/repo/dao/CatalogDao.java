package portaltek.hexa.spi.repo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import portaltek.hexa.spi.repo.entities.Catalog;


public interface CatalogDao extends CrudRepository<Catalog, Long> {

    @Query("FROM Catalog c WHERE c.company.id=?1 AND c.fiscalPeriod.id=?2")
    Catalog findByCompanyIdAndFiscalPeriodId(Long companyId, Long fiscalPeriodId);

}