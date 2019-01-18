package com.ps.batis.procedure.dao.domain;

import com.ps.batis.procedure.dao.model.TUserInfo;
import com.ps.batis.procedure.dao.model.TUserInfoExample;
import com.ps.batis.procedure.dao.model.TUserInfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TUserInfoMapper {
    @Delete({
        "delete from t_user_info",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into t_user_info (id, app_id, ",
        "cluster_id, user_name, ",
        "as_id, create_time, ",
        "modify_time, password, ",
        "salt, ispuk)",
        "values (#{id,jdbcType=VARCHAR}, #{appId,jdbcType=VARCHAR}, ",
        "#{clusterId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{asId,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{modifyTime,jdbcType=TIMESTAMP}, #{password,jdbcType=LONGVARBINARY}, ",
        "#{salt,jdbcType=LONGVARBINARY}, #{ispuk,jdbcType=LONGVARBINARY})"
    })
    int insert(TUserInfoWithBLOBs record);

    @InsertProvider(type=TUserInfoSqlProvider.class, method="insertSelective")
    int insertSelective(TUserInfoWithBLOBs record);

    @SelectProvider(type=TUserInfoSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="cluster_id", property="clusterId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="as_id", property="asId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="password", property="password", jdbcType=JdbcType.LONGVARBINARY),
        @Result(column="salt", property="salt", jdbcType=JdbcType.LONGVARBINARY),
        @Result(column="ispuk", property="ispuk", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<TUserInfoWithBLOBs> selectByExampleWithBLOBs(TUserInfoExample example);

    @SelectProvider(type=TUserInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="cluster_id", property="clusterId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="as_id", property="asId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TUserInfo> selectByExample(TUserInfoExample example);

    @Select({
        "select",
        "id, app_id, cluster_id, user_name, as_id, create_time, modify_time, password, ",
        "salt, ispuk",
        "from t_user_info",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="cluster_id", property="clusterId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="as_id", property="asId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="password", property="password", jdbcType=JdbcType.LONGVARBINARY),
        @Result(column="salt", property="salt", jdbcType=JdbcType.LONGVARBINARY),
        @Result(column="ispuk", property="ispuk", jdbcType=JdbcType.LONGVARBINARY)
    })
    TUserInfoWithBLOBs selectByPrimaryKey(String id);

    @UpdateProvider(type=TUserInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TUserInfoWithBLOBs record);

    @Update({
        "update t_user_info",
        "set app_id = #{appId,jdbcType=VARCHAR},",
          "cluster_id = #{clusterId,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "as_id = #{asId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP},",
          "password = #{password,jdbcType=LONGVARBINARY},",
          "salt = #{salt,jdbcType=LONGVARBINARY},",
          "ispuk = #{ispuk,jdbcType=LONGVARBINARY}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(TUserInfoWithBLOBs record);

    @Update({
        "update t_user_info",
        "set app_id = #{appId,jdbcType=VARCHAR},",
          "cluster_id = #{clusterId,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "as_id = #{asId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TUserInfo record);
}