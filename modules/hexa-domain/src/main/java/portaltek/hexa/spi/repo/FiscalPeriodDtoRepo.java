package portaltek.hexa.spi.repo;


import portaltek.hexa.domain.dto.catalog.FiscalPeriodDto;

public interface FiscalPeriodDtoRepo {
    FiscalPeriodDto findById(Long id);

    FiscalPeriodDto findByName(String name);
}
