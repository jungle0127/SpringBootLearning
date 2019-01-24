package com.ps.cache.bootredis.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
@Component
public class StopwatchRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("ps-test");
        for(int index = 0;index < 10; index++){
            Thread.sleep(300L);
            System.out.println(index);
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
