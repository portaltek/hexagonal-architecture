package portaltek.hexa.spi.repo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import portaltek.hexa.spi.repo.repo.CatalogDao;

@SpringBootApplication
public class HexaSpiRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexaSpiRepoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CatalogDao dao){
		return args -> { };
	}


}
