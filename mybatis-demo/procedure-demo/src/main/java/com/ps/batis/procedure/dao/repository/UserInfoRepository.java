package com.ps.batis.procedure.dao.repository;

import com.ps.batis.procedure.dao.domain.ProcDemoMapper;
import com.ps.batis.procedure.dao.model.ProcDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/*
 <select id="validateGroupMemberXml" parameterMap="java.util.Map" statementType="CALLABLE"
            resultType="com.ps.batis.procedure.dao.model.ValidateGroupMemberResult">
        call usp_validate_group_member( #{user_ids,jdbcType=TEXT,mode=IN},
        #{splitor,jdbcType=CHAR,mode=IN})
    </select>
 */
@Repository
public class UserInfoRepository {
    @Autowired
    private ProcDemoMapper procDemoMapper;
    public void test(){
        ProcDemo procDemo = procDemoMapper.selectByPrimaryKey(2L);
        System.out.println(procDemo.getUsername());
    }
    public String validateMember(String memberIds, String splitor){
        return "";
    }
}
