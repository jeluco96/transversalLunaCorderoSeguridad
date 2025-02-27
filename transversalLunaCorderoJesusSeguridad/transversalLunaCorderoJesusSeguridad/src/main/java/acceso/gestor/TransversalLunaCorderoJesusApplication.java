package acceso.gestor;

import org.springframework.boot.SpringApplication;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"acceso.gestor.models","utiles"})

public class TransversalLunaCorderoJesusApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransversalLunaCorderoJesusApplication.class, args);
	}

}
