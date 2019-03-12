package com.ps.srcread.startup.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

//@Component
public class StartUpRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Startup runner begin............................");
        StandardEnvironment env = new StandardEnvironment();
        String[] profiles = env.getActiveProfiles();
        System.out.println(profiles.length);
        for(String profile: profiles){
            System.out.println(profile);
        }
        System.out.println("Startup runner end..............................");
    }
}
