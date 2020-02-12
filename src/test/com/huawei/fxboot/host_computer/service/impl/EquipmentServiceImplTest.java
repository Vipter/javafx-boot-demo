package com.huawei.fxboot.host_computer.service.impl;

import com.huawei.fxboot.host_computer.domain.Equipment;
import com.huawei.fxboot.host_computer.service.EquipmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EquipmentServiceImplTest {
    @Autowired
    EquipmentService service;
    @Test
    public void test1(){
        List<Equipment> list = service.getEquipments();
        for (Equipment equ :list
             ) {
            System.out.println(equ.getName());
        }

    }
}