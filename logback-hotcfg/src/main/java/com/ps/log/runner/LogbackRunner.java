package com.ps.log.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class LogbackRunner implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void run(String... args) throws Exception {
        for(int index = 0;index< 1000;index++){
            logger.info("Log4j2 info level ============== {}", index);
            logger.debug("Log4j2 debug level ============== {}", index);
            TimeUnit.SECONDS.sleep(1L);
        }
    }
}
