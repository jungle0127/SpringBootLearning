package com.ps.batis.procedure.dao.domain;

import com.ps.batis.procedure.dao.model.ProcDemo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ProcDemoMapper {
    @Delete({
        "delete from proc_demo",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into proc_demo (id, username, ",
        "password, image_url, ",
        "role_name)",
        "values (#{id,jdbcType=BIGINT}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{imageUrl,jdbcType=VARCHAR}, ",
        "#{roleName,jdbcType=VARCHAR})"
    })
    int insert(ProcDemo record);

    @InsertProvider(type=ProcDemoSqlProvider.class, method="insertSelective")
    int insertSelective(ProcDemo record);

    @Select({
        "select",
        "id, username, password, image_url, role_name",
        "from proc_demo",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="image_url", property="imageUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR)
    })
    ProcDemo selectByPrimaryKey(Long id);

    @UpdateProvider(type=ProcDemoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProcDemo record);

    @Update({
        "update proc_demo",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "image_url = #{imageUrl,jdbcType=VARCHAR},",
          "role_name = #{roleName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ProcDemo record);
}