package com.ps.batis.procedure.dao.domain;

import com.ps.batis.procedure.dao.model.TUserDev;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TUserDevMapper {
    @Delete({
        "delete from t_user_dev",
        "where device_id = #{deviceId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String deviceId);

    @Insert({
        "insert into t_user_dev (device_id, id, ",
        "user_id, device_alias, ",
        "os_name, terminal_name, ",
        "create_time, user_device_keys_node_id, ",
        "deleted)",
        "values (#{deviceId,jdbcType=VARCHAR}, #{id,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=VARCHAR}, #{deviceAlias,jdbcType=VARCHAR}, ",
        "#{osName,jdbcType=VARCHAR}, #{terminalName,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{userDeviceKeysNodeId,jdbcType=CHAR}, ",
        "#{deleted,jdbcType=INTEGER})"
    })
    int insert(TUserDev record);

    @InsertProvider(type=TUserDevSqlProvider.class, method="insertSelective")
    int insertSelective(TUserDev record);

    @Select({
        "select",
        "device_id, id, user_id, device_alias, os_name, terminal_name, create_time, user_device_keys_node_id, ",
        "deleted",
        "from t_user_dev",
        "where device_id = #{deviceId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="device_id", property="deviceId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_alias", property="deviceAlias", jdbcType=JdbcType.VARCHAR),
        @Result(column="os_name", property="osName", jdbcType=JdbcType.VARCHAR),
        @Result(column="terminal_name", property="terminalName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_device_keys_node_id", property="userDeviceKeysNodeId", jdbcType=JdbcType.CHAR),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.INTEGER)
    })
    TUserDev selectByPrimaryKey(String deviceId);

    @UpdateProvider(type=TUserDevSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TUserDev record);

    @Update({
        "update t_user_dev",
        "set id = #{id,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=VARCHAR},",
          "device_alias = #{deviceAlias,jdbcType=VARCHAR},",
          "os_name = #{osName,jdbcType=VARCHAR},",
          "terminal_name = #{terminalName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "user_device_keys_node_id = #{userDeviceKeysNodeId,jdbcType=CHAR},",
          "deleted = #{deleted,jdbcType=INTEGER}",
        "where device_id = #{deviceId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TUserDev record);
}