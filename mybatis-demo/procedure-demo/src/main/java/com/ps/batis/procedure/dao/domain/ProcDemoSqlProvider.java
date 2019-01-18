package com.ps.batis.procedure.dao.domain;

import com.ps.batis.procedure.dao.model.ProcDemo;
import org.apache.ibatis.jdbc.SQL;

public class ProcDemoSqlProvider {

    public String insertSelective(ProcDemo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("proc_demo");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getImageUrl() != null) {
            sql.VALUES("image_url", "#{imageUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleName() != null) {
            sql.VALUES("role_name", "#{roleName,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ProcDemo record) {
        SQL sql = new SQL();
        sql.UPDATE("proc_demo");
        
        if (record.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getImageUrl() != null) {
            sql.SET("image_url = #{imageUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleName() != null) {
            sql.SET("role_name = #{roleName,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}