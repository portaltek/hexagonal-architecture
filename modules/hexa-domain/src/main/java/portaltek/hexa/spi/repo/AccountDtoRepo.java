package portaltek.hexa.spi.repo;


import portaltek.hexa.domain.dto.catalog.AccountDto;
import portaltek.hexa.domain.dto.catalog.CatalogDto;

import java.util.List;

public interface AccountDtoRepo {
    AccountDto findById(Long id);

    AccountDto findByCode(String id);

    List<AccountDto> findByAccountCatalog(CatalogDto catalogDto);
}
