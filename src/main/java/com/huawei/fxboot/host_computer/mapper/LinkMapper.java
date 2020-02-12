package com.huawei.fxboot.host_computer.mapper;

import com.huawei.fxboot.host_computer.domain.Link;
import com.huawei.fxboot.host_computer.domain.entity.LinkEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface LinkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LinkEntity record);

    int insertSelective(LinkEntity record);

    LinkEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LinkEntity record);

    int updateByPrimaryKey(LinkEntity record);

    Integer insertConnectRelationship(@Param(value = "sqlStr") String sqlStr);

    Integer disConnectRelationship(@Param(value = "disSql") String disSql);

    List<Link> getLink(@Param("occupier")String occupier);
}