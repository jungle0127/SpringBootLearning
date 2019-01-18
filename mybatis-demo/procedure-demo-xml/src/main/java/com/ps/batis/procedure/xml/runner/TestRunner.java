package com.ps.batis.procedure.xml.runner;

import com.ps.batis.procedure.xml.dao.domain.ProcDemoMapper;
import com.ps.batis.procedure.xml.dao.model.ProcDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {
    @Autowired
    private ProcDemoMapper procDemoMapper;
    @Override
    public void run(String... args) throws Exception {
        ProcDemo procDemo = this.procDemoMapper.selectByPrimaryKey(1L);
        System.out.println(procDemo.getUsername());
    }
}
