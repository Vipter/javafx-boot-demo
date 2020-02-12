package com.huawei.fxboot.host_computer.service.impl;

import com.huawei.fxboot.host_computer.domain.Equipment;
import com.huawei.fxboot.host_computer.domain.EquipmentTopoOccupy;
import com.huawei.fxboot.host_computer.domain.Link;
import com.huawei.fxboot.host_computer.domain.Topo;
import com.huawei.fxboot.host_computer.mapper.EquipmentMapper;
import com.huawei.fxboot.host_computer.mapper.LinkMapper;
import com.huawei.fxboot.host_computer.mapper.TopoMapper;
import com.huawei.fxboot.host_computer.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    EquipmentMapper equipmentMapper;
    @Autowired
    LinkMapper linkMapper;
    @Autowired
    TopoMapper topoMapper;

    @Override
    public List<Equipment> getEquipments() {
        return equipmentMapper.getEquipments();
    }

    @Override
    public void deleteEquipment(Integer id) {
        equipmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void occupyEquipment(String occupier, Integer id) {
        equipmentMapper.occupyEquipment(occupier, id);
    }

    @Override
    public Equipment getOccupyEquipment(Integer id) {
        return equipmentMapper.getOccupyEquipment(id);
    }

    @Override
    public void insertConnectRelationship(String sql) {
        linkMapper.insertConnectRelationship(sql);
    }

    @Override
    public void disConnectRelationship(String disSql) {
        linkMapper.disConnectRelationship(disSql);
    }

    @Override
    public void saveNodePosition(Topo topo) {
        topoMapper.saveNodePosition(topo);
    }

    @Override
    public List<EquipmentTopoOccupy> getTopoEquipment(String occupier) {
        return topoMapper.getTopoEquipment(occupier);
    }

    @Override
    public List<Link> getLink(String occupier) {
        return linkMapper.getLink(occupier);
    }

}
