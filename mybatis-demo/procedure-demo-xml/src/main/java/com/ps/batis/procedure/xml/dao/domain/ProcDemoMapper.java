package com.ps.batis.procedure.xml.dao.domain;

import com.ps.batis.procedure.xml.dao.model.ProcDemo;

public interface ProcDemoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProcDemo record);

    int insertSelective(ProcDemo record);

    ProcDemo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProcDemo record);

    int updateByPrimaryKey(ProcDemo record);
}