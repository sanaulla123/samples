package info.sanaulla;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AppServiceAsync {

    @Async
    public void doSomeWorkAsync(){
        log.info("Doing some work in true async...");
    }
}
