package portaltek.hexa.spi.repo;


import portaltek.hexa.domain.dto.catalog.Account;
import portaltek.hexa.domain.dto.catalog.Catalog;

import java.util.List;

public interface AccountRepo {
    Account findById(Long id);

    Account findByCode(String id);

    List<Account> findByAccountCatalog(Catalog catalog);
}
