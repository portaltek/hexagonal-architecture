package portaltek.hexa.domain.svc.catalog;

import lombok.Value;
import lombok.experimental.Accessors;
import org.apache.commons.collections4.CollectionUtils;
import portaltek.hexa.domain.HexaException;
import portaltek.hexa.domain.dto.catalog.Account;

import java.util.Set;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static portaltek.hexa.domain.enums.ErrorType.*;
import static portaltek.hexa.domain.enums.UseCaseType.IMPORT_CATALOG_CMD;

@Value
@Accessors(fluent = true)
public class ImportCatalogCmd {

    private Long companyId;
    private Long fiscalPeriodId;
    private Set<Account> accounts;

    public ImportCatalogCmd(Long companyId,
                            Long fiscalPeriodId,
                            Set<Account> accounts)
            throws HexaException {
        this.companyId = companyId;
        this.fiscalPeriodId = fiscalPeriodId;
        this.accounts = accounts;
        validate();
    }

    private void validate() throws HexaException {
        HexaException exception = HexaException.of(IMPORT_CATALOG_CMD);

        if (companyId == null) {
            exception.add(COMPANY_IS_EMPTY);
        }
        if (fiscalPeriodId == null) {
            exception.add(FISCAL_PERIOD_IS_EMPTY);
        }
        if (CollectionUtils.isEmpty(accounts)) {
            exception.add(ACCOUNT_LIST_IS_EMPTY);
        } else {
            accounts.stream()
                    .forEach(i -> validate(i, exception));
        }

        if (exception.hasErrors()) throw exception;
    }

    private void validate(Account account, HexaException exception) {
        if (isEmpty(account.description()) ||
                isEmpty(account.name()) ||
                isEmpty(account.code())) {
            exception.add(ACCOUNT_IS_INVALID, account.toString());
        }
    }

}

