package com.ps.batis.procedure.dao.domain;

import com.ps.batis.procedure.dao.model.TUserDev;
import org.apache.ibatis.jdbc.SQL;

public class TUserDevSqlProvider {

    public String insertSelective(TUserDev record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_user_dev");
        
        if (record.getDeviceId() != null) {
            sql.VALUES("device_id", "#{deviceId,jdbcType=VARCHAR}");
        }
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getDeviceAlias() != null) {
            sql.VALUES("device_alias", "#{deviceAlias,jdbcType=VARCHAR}");
        }
        
        if (record.getOsName() != null) {
            sql.VALUES("os_name", "#{osName,jdbcType=VARCHAR}");
        }
        
        if (record.getTerminalName() != null) {
            sql.VALUES("terminal_name", "#{terminalName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserDeviceKeysNodeId() != null) {
            sql.VALUES("user_device_keys_node_id", "#{userDeviceKeysNodeId,jdbcType=CHAR}");
        }
        
        if (record.getDeleted() != null) {
            sql.VALUES("deleted", "#{deleted,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TUserDev record) {
        SQL sql = new SQL();
        sql.UPDATE("t_user_dev");
        
        if (record.getId() != null) {
            sql.SET("id = #{id,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getDeviceAlias() != null) {
            sql.SET("device_alias = #{deviceAlias,jdbcType=VARCHAR}");
        }
        
        if (record.getOsName() != null) {
            sql.SET("os_name = #{osName,jdbcType=VARCHAR}");
        }
        
        if (record.getTerminalName() != null) {
            sql.SET("terminal_name = #{terminalName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserDeviceKeysNodeId() != null) {
            sql.SET("user_device_keys_node_id = #{userDeviceKeysNodeId,jdbcType=CHAR}");
        }
        
        if (record.getDeleted() != null) {
            sql.SET("deleted = #{deleted,jdbcType=INTEGER}");
        }
        
        sql.WHERE("device_id = #{deviceId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}