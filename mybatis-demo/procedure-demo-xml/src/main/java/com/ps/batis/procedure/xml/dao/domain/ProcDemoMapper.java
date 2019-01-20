package com.ps.batis.procedure.xml.dao.domain;

import com.ps.batis.procedure.xml.dao.model.ProcDemo;

import java.util.List;
import java.util.Map;

public interface ProcDemoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProcDemo record);

    int insertSelective(ProcDemo record);

    int inserBatchRows(List<ProcDemo> userItemList);

    ProcDemo selectByPrimaryKey(Long id);

    String validateMemberProc(Map<String,String> requestMap);
    String uspUutputParam(Map<String,String> requestMap);
    List<ProcDemo> uspResultList(Map<String,String> requestMap);
    int updateByPrimaryKeySelective(ProcDemo record);

    int updateByPrimaryKey(ProcDemo record);
}