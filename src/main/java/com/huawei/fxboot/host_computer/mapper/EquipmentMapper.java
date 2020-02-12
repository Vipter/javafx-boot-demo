package com.huawei.fxboot.host_computer.mapper;

import com.huawei.fxboot.host_computer.domain.Equipment;
import com.huawei.fxboot.host_computer.domain.entity.EquipmentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface EquipmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentEntity record);

    int insertSelective(EquipmentEntity record);

    EquipmentEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EquipmentEntity record);

    int updateByPrimaryKey(EquipmentEntity record);
    List<Equipment> getEquipments();
    Integer occupyEquipment(@Param("occupier") String occupier, @Param("id") Integer id);
    Equipment getOccupyEquipment(@Param("id")Integer id);
}