package com.ps.batis.procedure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ps.batis.procedure.dao.domain")
public class ProcedureApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProcedureApplication.class,args);
    }
}
