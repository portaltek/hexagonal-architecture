package portaltek.hexa.domain.dto.transaction;

import lombok.Builder;
import lombok.Data;
import portaltek.hexa.domain.dto.catalog.Account;

import java.math.BigDecimal;

@Data
@Builder
public class PolicyTransaction {

    private Long id;
    private Policy policy;
    private Account account;
    private BigDecimal credit;
    private BigDecimal debit;



}
