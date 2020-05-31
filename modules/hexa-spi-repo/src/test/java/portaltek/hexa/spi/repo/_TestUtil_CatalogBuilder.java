package portaltek.hexa.spi.repo;

import portaltek.hexa.spi.repo.entities.Account;
import portaltek.hexa.spi.repo.entities.Catalog;
import portaltek.hexa.spi.repo.entities.Company;
import portaltek.hexa.spi.repo.entities.FiscalPeriod;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.time.LocalDateTime.now;

public class _TestUtil_CatalogBuilder {

    public static FiscalPeriod getValidFiscalPeriod(Long id) {
        LocalDateTime now = now();
        return new FiscalPeriod().start(now)
                .end(now.plusYears(1))
                .name("FiscalYear" + id);
    }

    public static Company getValidCompany(Long id) {
        return new Company().id(id)
                .code("CompanyCode" + id)
                .description("CompanyDescription" + id)
                .name("CompanyName" + id)
                ;
    }

    public static Account getValidAccount(Long id) {
        return new Account().id(id)
                .code("AccountCode" + id)
                .description("CompanyDescription" + id)
                .name("CompanyName" + id);
    }

    public static List<Account> getValidAccounts(Long id) {
        return LongStream.range(0, id)
                .mapToObj(i -> getValidAccount(i))
                .collect(Collectors.toList());
    }

    public static Catalog getValidCatalog(Long id, Long accountListSize) {

        return new Catalog().id(id)
                .accounts(getValidAccounts(accountListSize))
                .company(getValidCompany(id))
                .fiscalPeriod(getValidFiscalPeriod(id));

    }
}
