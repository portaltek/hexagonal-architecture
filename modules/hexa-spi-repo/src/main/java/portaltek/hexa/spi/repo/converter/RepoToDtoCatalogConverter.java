package portaltek.hexa.spi.repo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portaltek.hexa.domain.dto.catalog.CatalogDto;
import portaltek.hexa.domain.dto.catalog.CompanyDto;
import portaltek.hexa.domain.dto.catalog.FiscalPeriodDto;
import portaltek.hexa.spi.repo.entities.Catalog;

@Service
public class RepoToDtoCatalogConverter implements Converter<Catalog, CatalogDto> {

    @Autowired
    private RepoToDtoCompanyConverter companyConverter;
    @Autowired
    private RepoToDtoFiscalPeriodConverter fiscalPeriodConverter;

    @Override
    public CatalogDto from(Catalog input) {
        CompanyDto companyDto = companyConverter.from(input.company());
        FiscalPeriodDto fiscalPeriodDto = fiscalPeriodConverter.from(input.fiscalPeriod());
        return new CatalogDto()
                .id(input.id())
                .fiscalPeriodDto(fiscalPeriodDto)
                .companyDto(companyDto);
    }
}