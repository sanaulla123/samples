package info.sanaulla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsyncGotchaApplication implements CommandLineRunner {

    @Autowired AppService appService;

    public static void main(String[] args) {
        SpringApplication.run(AsyncGotchaApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        appService.doSomeWork();
        appService.doSomeWorkTrueAsync();
    }
}
