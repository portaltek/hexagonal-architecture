package portaltek.hexa.spi.repo.converter;

import org.springframework.stereotype.Service;
import portaltek.hexa.domain.dto.catalog.CompanyDto;
import portaltek.hexa.spi.repo.entities.Company;

@Service
public class RepoToDtoCompanyConverter implements Converter<Company, CompanyDto> {

    @Override
    public CompanyDto from(Company input) {
        return new CompanyDto()
                .id(input.id())
                .code(input.code())
                .name(input.name())
                .description(input.description())
                ;
    }
}