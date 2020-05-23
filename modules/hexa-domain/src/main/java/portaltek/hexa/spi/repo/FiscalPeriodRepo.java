package portaltek.hexa.spi.repo;


import portaltek.hexa.domain.dto.catalog.FiscalPeriod;

public interface FiscalPeriodRepo {
    FiscalPeriod findById(Long id);

    FiscalPeriod findByName(String name);
}
