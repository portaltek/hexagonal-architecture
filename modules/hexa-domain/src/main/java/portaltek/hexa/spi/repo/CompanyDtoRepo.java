package portaltek.hexa.spi.repo;

import portaltek.hexa.domain.dto.catalog.CompanyDto;

public interface CompanyDtoRepo {
    CompanyDto findById(Long id);

}
