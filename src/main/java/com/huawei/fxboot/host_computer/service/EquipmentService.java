package com.huawei.fxboot.host_computer.service;

import com.huawei.fxboot.host_computer.domain.Equipment;
import com.huawei.fxboot.host_computer.domain.EquipmentTopoOccupy;
import com.huawei.fxboot.host_computer.domain.Link;
import com.huawei.fxboot.host_computer.domain.Topo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EquipmentService {
    List<Equipment> getEquipments();
    void deleteEquipment(Integer id);
    void occupyEquipment(String occupier,Integer id);
    Equipment getOccupyEquipment(Integer id);
    void insertConnectRelationship(String sql);
    void disConnectRelationship(String disSql);
    void saveNodePosition(Topo topo);
    List<EquipmentTopoOccupy> getTopoEquipment(String occupier);
    List<Link> getLink(String occupier);
}

