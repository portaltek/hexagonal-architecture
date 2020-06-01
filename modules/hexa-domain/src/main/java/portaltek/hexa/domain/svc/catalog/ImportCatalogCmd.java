package portaltek.hexa.domain.svc.catalog;

import lombok.Value;
import lombok.experimental.Accessors;
import org.apache.commons.collections4.CollectionUtils;
import portaltek.hexa.domain.HexaException;
import portaltek.hexa.domain.dto.catalog.AccountDto;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static portaltek.hexa.domain.enums.ErrorType.*;
import static portaltek.hexa.domain.enums.UseCaseType.IMPORT_CATALOG_CMD;

@Value
@Accessors(fluent = true)
public class ImportCatalogCmd {

    private Long companyId;
    private Long fiscalPeriodId;
    private List<AccountDto> accountDtos;

    public ImportCatalogCmd(Long companyId,
                            Long fiscalPeriodId,
                            List<AccountDto> accountDtos)
            throws HexaException {
        this.companyId = companyId;
        this.fiscalPeriodId = fiscalPeriodId;
        this.accountDtos = accountDtos;
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
        if (CollectionUtils.isEmpty(accountDtos)) {
            exception.add(ACCOUNT_LIST_IS_EMPTY);
        } else {
            accountDtos.stream()
                    .forEach(i -> validate(i, exception));
        }

        if (exception.hasErrors()) throw exception;
    }


    private void validate(AccountDto accountDto, HexaException exception) {
        validateUnique(accountDto, exception);
        if (isEmpty(accountDto.description()) ||
                isEmpty(accountDto.name()) ||
                isEmpty(accountDto.code())) {
            exception.add(ACCOUNT_IS_INVALID, accountDto.toString());
        }
    }

    private void validateUnique(AccountDto accountDto, HexaException exception) {
        if (hasDuplicatedAccountId(accountDto)) {
            exception.add(ACCOUNT_ID_DUPLICATED, accountDto.toString());
        }
        if (hasDuplicatedAccountCode(accountDto)) {
            exception.add(ACCOUNT_CODE_DUPLICATED, accountDto.toString());
        }
    }

    private boolean hasDuplicatedAccountCode(AccountDto accountDto) {
        return accountDtos.stream().filter(a -> a.code().equals(accountDto.code()))
                .count() > 1;
    }

    private boolean hasDuplicatedAccountId(AccountDto accountDto) {
        return accountDtos.stream().filter(a -> a.id().equals(accountDto.id()))
                .count() > 1;
    }


}

