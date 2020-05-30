package portaltek.hexa.spi.repo.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(fluent = true)
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String code;
    private String name;
    private String description;
    @ManyToOne
    private Catalog catalog;




}
