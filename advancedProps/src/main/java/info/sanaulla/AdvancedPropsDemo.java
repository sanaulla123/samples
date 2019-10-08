package info.sanaulla;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class AdvancedPropsDemo implements ApplicationRunner {

    @Value("${app.name}")
    String appName;

    public static void main(String[] args) {
        new SpringApplication(AdvancedPropsDemo.class).run(args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("App Name value " + appName);
    }
}
