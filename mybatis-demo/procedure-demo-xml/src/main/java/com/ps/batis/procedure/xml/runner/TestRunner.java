package com.ps.batis.procedure.xml.runner;

import com.ps.batis.procedure.xml.dao.domain.ProcDemoMapper;
import com.ps.batis.procedure.xml.dao.model.ProcDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

@Component
public class TestRunner implements CommandLineRunner {
    @Autowired
    private ProcDemoMapper procDemoMapper;
    @Override
    public void run(String... args) throws Exception {
        Map<String,String> param = new HashMap<>();
        param.put("userIds","test");
        param.put("splitor",",");

        String procDemo  = this.procDemoMapper.validateMemberProc(param);
        System.out.println(procDemo);
    }
}
