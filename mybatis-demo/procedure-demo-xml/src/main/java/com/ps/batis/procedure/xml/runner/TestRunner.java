package com.ps.batis.procedure.xml.runner;

import com.ps.batis.procedure.xml.dao.domain.ProcDemoMapper;
import com.ps.batis.procedure.xml.dao.model.ProcDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TestRunner implements CommandLineRunner {
    @Autowired
    private ProcDemoMapper procDemoMapper;

    @Override
    public void run(String... args) throws Exception {
        this.testValidateMembers();
        this.testUspOutputParam();
        this.testUspResultList();
    }

    private void testValidateMembers(){
        Map<String,String> param = new HashMap<>();
        param.put("userIds","test");
        param.put("splitor",",");

        String procDemo  = this.procDemoMapper.validateMemberProc(param);
        System.out.println(procDemo);
    }
    private void testUspOutputParam(){
        Map<String,String> param = new HashMap<>();
        param.put("userIds","userIdParameter");
        param.put("splitor",",");
        this.procDemoMapper.uspUutputParam(param);
        System.out.println(param.get("invalid_members"));
    }
    private void testUspResultList(){
        Map<String,String> param = new HashMap<>();
        param.put("userIds","userIdParameter");
        param.put("splitor",",");
        List<ProcDemo> resultList = this.procDemoMapper.uspResultList(param);
        for(ProcDemo item: resultList){
            System.out.println(item.toString());
        }
    }
}
