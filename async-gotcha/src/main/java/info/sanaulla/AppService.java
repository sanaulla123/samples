package info.sanaulla;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AppService {

    @Autowired AppServiceAsync appServiceAsync;

    public void doSomeWork(){
        log.info("Doing some work...");
        doSomeWorkAsync();
    }
    public void doSomeWorkTrueAsync(){
        log.info("Doing some work again...");
        appServiceAsync.doSomeWorkAsync();
    }

    @Async
    public void doSomeWorkAsync(){
        log.info("Doing some work async...");
    }
}
