package portaltek.hexa.domain.svc.catalog;

import lombok.Value;
import lombok.experimental.Accessors;
import org.apache.commons.collections4.CollectionUtils;
import portaltek.hexa.domain.HexaException;
import portaltek.hexa.domain.dto.catalog.Account;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static portaltek.hexa.domain.enums.ErrorType.*;
import static portaltek.hexa.domain.enums.UseCaseType.IMPORT_CATALOG_CMD;

@Value
@Accessors(fluent = true)
public class ImportCatalogCmd {

    private Long companyId;
    private Long fiscalPeriodId;
    private List<Account> accounts;

    public ImportCatalogCmd(Long companyId,
                            Long fiscalPeriodId,
                            List<Account> accounts)
            throws HexaException {
        this.companyId = companyId;
        this.fiscalPeriodId = fiscalPeriodId;
        this.accounts = accounts;
        validate();
    }

    public void validate() throws HexaException {
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
        validateUnique(account, exception);
        if (isEmpty(account.description()) ||
                isEmpty(account.name()) ||
                isEmpty(account.code())) {
            exception.add(ACCOUNT_IS_INVALID, account.toString());
        }
    }

    private void validateUnique(Account account, HexaException exception) {
        if (hasDuplicatedAccountId(account)) {
            exception.add(ACCOUNT_ID_DUPLICATED, account.toString());
        }
        if (hasDuplicatedAccountCode(account)) {
            exception.add(ACCOUNT_CODE_DUPLICATED, account.toString());
        }
    }

    private boolean hasDuplicatedAccountCode(Account account) {
        return accounts.stream().filter(a -> a.code().equals(account.code()))
                .count() > 1;
    }

    private boolean hasDuplicatedAccountId(Account account) {
        return accounts.stream().filter(a -> a.id().equals(account.id()))
                .count() > 1;
    }


}

