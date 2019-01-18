package com.ps.batis.procedure.dao.repository;

import com.ps.batis.procedure.dao.domain.TAdminMapper;
import com.ps.batis.procedure.dao.domain.TUserInfoMapper;
import com.ps.batis.procedure.dao.model.TAdmin;
import com.ps.batis.procedure.dao.model.TAdminWithBLOBs;
import com.ps.batis.procedure.dao.model.TUserInfoWithBLOBs;
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
    private TUserInfoMapper userInfoMapper;
    @Autowired
    private TAdminMapper adminMapper;
    public void test(){
        Map<String,TAdmin> items = new HashMap<>();
        TAdminWithBLOBs pojo = new TAdminWithBLOBs();
        pojo.setPassword("lotus".getBytes());
        pojo.setSalt("salt".getBytes());
        pojo.setAccountNumber("accountnumber");
        pojo.setComment("comment");
        pojo.setCreateTime(new Date());
        pojo.setId("uuid-id-1");
        pojo.setRole("role");
        pojo.setStatus(1);
        pojo.setUserName("ps");
        items.put("1",pojo);
        pojo =new TAdminWithBLOBs();
        pojo.setPassword("lotus".getBytes());
        pojo.setSalt("salt".getBytes());
        pojo.setAccountNumber("accountnumber");
        pojo.setComment("comment");
        pojo.setCreateTime(new Date());
        pojo.setId("uuid-id-2");
        pojo.setRole("role");
        pojo.setStatus(1);
        pojo.setUserName("ps");
        items.put("2",pojo);
        int result = this.adminMapper.insertCollections(items);
        if(result == 1){
            System.out.println("Insert DONE>");
        }
    }
    public String validateMember(String memberIds, String splitor){
        Map<String,String> request = new HashMap<>();
        request.put("user_ids",memberIds);
        request.put("splitor",splitor);
//        ValidateGroupMemberResult invalidMembers = this.userInfoMapper.validateGroupMemberXml(request);
//        return invalidMembers.getInvalidMemberIds();
        return "";
    }
}
