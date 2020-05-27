package portaltek.hexa.spi.repo.entities;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
@Data
@Builder
@Accessors(fluent = true)
public class Catalog {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Company company;
    private FiscalPeriod fiscalPeriod;
    private Set<Account> accountList;




}