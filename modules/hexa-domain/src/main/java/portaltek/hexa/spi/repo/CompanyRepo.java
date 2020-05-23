package portaltek.hexa.spi.repo;

import portaltek.hexa.domain.dto.catalog.Company;

public interface CompanyRepo  {
    Company findById(Long id);
    Company findByName(String name);
}
