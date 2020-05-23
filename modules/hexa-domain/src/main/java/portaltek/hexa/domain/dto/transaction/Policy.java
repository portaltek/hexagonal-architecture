package portaltek.hexa.domain.dto.transaction;

import lombok.Builder;
import lombok.Data;
import portaltek.hexa.domain.dto.catalog.Company;
import portaltek.hexa.domain.dto.catalog.FiscalPeriod;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Policy {

    private Long id;
    private Company company;
    private FiscalPeriod fiscalPeriod;
    private LocalDateTime timestamp;
    private BigDecimal credit;
    private BigDecimal debit;
    private List<PolicyTransaction> policyTransactionList;

}
