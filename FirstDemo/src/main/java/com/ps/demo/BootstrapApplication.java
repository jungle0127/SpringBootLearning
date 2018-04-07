package com.ps.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * First demo for springboot
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
public class BootstrapApplication {
	public static void main(String[] args) {
//		SpringApplication.run(BootstrapApplication.class);
		SpringApplication app = new SpringApplication(BootstrapApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
		/**
		 * Close Banner of spring boot.
		 */
	}
}
