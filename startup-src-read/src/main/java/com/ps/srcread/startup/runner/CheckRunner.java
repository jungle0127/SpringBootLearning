package com.ps.srcread.startup.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CheckRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        // https, http,ftp
        final String authUrl = "http://192.168.2.34/oauth/token";
        String schema = authUrl.substring(0,authUrl.indexOf(":"));
        String authUrlWithoutSchema = authUrl.substring(schema.length() + 3);
        String authIpAddress = authUrlWithoutSchema.substring(0,authUrlWithoutSchema.indexOf('/'));
        String redirectUrl = String.format("%s://%s/default.html",schema,authIpAddress);
        System.out.println(redirectUrl);
    }
}
