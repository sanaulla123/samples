package info.sanaulla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableJpaRepositories
@EnableSpringDataWebSupport
public class SpringBootVuejsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVuejsApplication.class, args);
	}
}
