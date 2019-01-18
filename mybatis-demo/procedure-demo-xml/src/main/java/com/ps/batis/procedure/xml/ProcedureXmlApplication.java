package com.ps.batis.procedure.xml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ps.batis.procedure.xml.dao.domain")
public class ProcedureXmlApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProcedureXmlApplication.class,args);
    }
}
