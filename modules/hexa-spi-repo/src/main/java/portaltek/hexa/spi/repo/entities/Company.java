package portaltek.hexa.spi.repo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Accessors(fluent = true)
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String code;
    private String name;
    private String description;

}
