package portaltek.hexa.spi.repo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Data
@Accessors(fluent = true)
@NoArgsConstructor
public class Catalog {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Company company;
    @ManyToOne
    private FiscalPeriod fiscalPeriod;
    @OneToMany
    @JoinColumn(name = "catalog_id")
    private List<Account> accounts;


}