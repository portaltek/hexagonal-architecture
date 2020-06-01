package portaltek.hexa.spi.repo.converter;

import org.springframework.stereotype.Service;
import portaltek.hexa.domain.dto.catalog.FiscalPeriodDto;
import portaltek.hexa.spi.repo.entities.FiscalPeriod;

@Service
public class RepoToDtoFiscalPeriodConverter implements Converter<FiscalPeriod, FiscalPeriodDto> {

    public FiscalPeriodDto from(FiscalPeriod input) {
        return new FiscalPeriodDto()
                .id(input.id())
                .end(input.end())
                .start(input.start())
                .name(input.name());

    }
}
