package com.ps.batis.procedure.xml.runner;

import com.ps.batis.procedure.xml.dao.domain.ProcDemoMapper;
import com.ps.batis.procedure.xml.dao.model.ProcDemo;
import com.ps.batis.procedure.xml.dao.model.UsernamePassword;
import com.ps.batis.procedure.xml.dao.model.UsernameRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class TestRunner implements CommandLineRunner {
    @Autowired
    private ProcDemoMapper procDemoMapper;

    @Override
    public void run(String... args) throws Exception {
        this.testMultipleData();
        this.insertBatchItems();
        this.testValidateMembers();
        this.testUspOutputParam();
        this.testUspResultList();
    }
    private void testMultipleData(){
        Map<String,String> param = new HashMap<>();
        param.put("userIds","test");
        param.put("splitor",",");
        List<List<?>> memberList = this.procDemoMapper.uspMultipleData(param);
        for(List<?> item:memberList){
            System.out.println(item.size());
        }
        List<UsernamePassword> usernamePasswordList = (List<UsernamePassword>)memberList.get(0);
        for(UsernamePassword up: usernamePasswordList){
            System.out.println(up.toString());
        }
        List<UsernameRole> usernameRoleList = (List<UsernameRole>) memberList.get(1);
        for(UsernameRole ur: usernameRoleList){
            System.out.println(ur.toString());
        }
    }
    private void insertBatchItems(){
        List<ProcDemo> procDemoList = new LinkedList<>();
        ProcDemo procDemo = new ProcDemo();
        procDemo.setImageUrl("b1imageurl");
        procDemo.setPassword("b1pwd");
        procDemo.setRoleName("b1rolename");
        procDemo.setUsername("b1usr");
        procDemoList.add(procDemo);
        procDemo = new ProcDemo();
        procDemo.setUsername("b2usr");
        procDemo.setRoleName("b2rolename");
        procDemo.setPassword("b2pwd");
        procDemo.setImageUrl("b2imageurl");
        procDemoList.add(procDemo);
        int result = this.procDemoMapper.inserBatchRows(procDemoList);
        System.out.println("Insert batch rows:" + result);
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
        System.out.println(param.get("existed_members"));
        System.out.println(param.get("valid_members"));
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
