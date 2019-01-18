package com.ps.batis.procedure.dao.domain;

import com.ps.batis.procedure.dao.model.TAdmin;
import com.ps.batis.procedure.dao.model.TAdminWithBLOBs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.Map;

public interface TAdminMapper {
    @Delete({
        "delete from t_admin",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into t_admin (id, account_number, ",
        "user_name, role, ",
        "status, comment, ",
        "create_time, password, ",
        "salt)",
        "values (#{id,jdbcType=VARCHAR}, #{accountNumber,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR}, #{role,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{comment,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{password,jdbcType=BINARY}, ",
        "#{salt,jdbcType=LONGVARBINARY})"
    })
    int insert(TAdminWithBLOBs record);

    @InsertProvider(type=TAdminSqlProvider.class, method="insertSelective")
    int insertSelective(TAdminWithBLOBs record);
    @Insert({
            "<script>",
            "insert into t_admin (id, account_number, ",
            "user_name, role, ",
            "status, comment, ",
            "create_time, password, ",
            "salt) ",
            "values",
            "<foreach item='value' index='key' collection='items' separator=','>",
            "(#{id},#{accountNumber}, #{userName},#{role},#{status},#{comment},#{createTime},#{password},#{salt})",
            "</foreach>",
            "</script>"
    })
    int insertCollections(Map<String,TAdmin> items);

    @Select({
        "select",
        "id, account_number, user_name, role, status, comment, create_time, password, ",
        "salt",
        "from t_admin",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="account_number", property="accountNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="role", property="role", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="password", property="password", jdbcType=JdbcType.BINARY),
        @Result(column="salt", property="salt", jdbcType=JdbcType.LONGVARBINARY)
    })
    TAdminWithBLOBs selectByPrimaryKey(String id);

    @UpdateProvider(type=TAdminSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TAdminWithBLOBs record);

    @Update({
        "update t_admin",
        "set account_number = #{accountNumber,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "role = #{role,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "comment = #{comment,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "password = #{password,jdbcType=BINARY},",
          "salt = #{salt,jdbcType=LONGVARBINARY}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(TAdminWithBLOBs record);

    @Update({
        "update t_admin",
        "set account_number = #{accountNumber,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "role = #{role,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "comment = #{comment,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TAdmin record);
}