package pe.bugcatcorporation.commerce.BugcatApiProductoCategoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BugcatApiProductoCategoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugcatApiProductoCategoriaApplication.class, args);
	}

}
