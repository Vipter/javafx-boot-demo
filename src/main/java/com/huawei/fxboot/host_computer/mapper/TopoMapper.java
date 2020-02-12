package com.huawei.fxboot.host_computer.mapper;

import com.huawei.fxboot.host_computer.domain.EquipmentTopoOccupy;
import com.huawei.fxboot.host_computer.domain.Topo;
import com.huawei.fxboot.host_computer.domain.entity.TopoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TopoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TopoEntity record);

    int insertSelective(TopoEntity record);

    TopoEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TopoEntity record);

    int updateByPrimaryKey(TopoEntity record);

    Integer saveNodePosition(Topo topo);

    List<EquipmentTopoOccupy> getTopoEquipment(@Param("occupier") String occupier);

}