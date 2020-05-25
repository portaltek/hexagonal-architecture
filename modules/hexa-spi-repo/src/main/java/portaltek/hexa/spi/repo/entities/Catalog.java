package portaltek.hexa.spi.repo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class Catalog {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
//    private Company company;
//    private FiscalPeriod fiscalPeriod;
//    private Set<Account> accountList;




}