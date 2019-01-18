package com.ps.batis.procedure.dao.domain;

import com.ps.batis.procedure.dao.model.TAdminWithBLOBs;
import org.apache.ibatis.jdbc.SQL;

public class TAdminSqlProvider {

    public String insertSelective(TAdminWithBLOBs record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_admin");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountNumber() != null) {
            sql.VALUES("account_number", "#{accountNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getRole() != null) {
            sql.VALUES("role", "#{role,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getComment() != null) {
            sql.VALUES("comment", "#{comment,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=BINARY}");
        }
        
        if (record.getSalt() != null) {
            sql.VALUES("salt", "#{salt,jdbcType=LONGVARBINARY}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TAdminWithBLOBs record) {
        SQL sql = new SQL();
        sql.UPDATE("t_admin");
        
        if (record.getAccountNumber() != null) {
            sql.SET("account_number = #{accountNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getRole() != null) {
            sql.SET("role = #{role,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getComment() != null) {
            sql.SET("comment = #{comment,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=BINARY}");
        }
        
        if (record.getSalt() != null) {
            sql.SET("salt = #{salt,jdbcType=LONGVARBINARY}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}