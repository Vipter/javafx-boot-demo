package com.huawei.fxboot.host_computer.mapper;

import com.huawei.fxboot.host_computer.domain.Link;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LinkMapperTest {
    @Autowired
    LinkMapper mapper;


    @Test
    public void test(){
        mapper.insertConnectRelationship("insert into link (switch_id,route_id) values(1,5)");
        System.out.println("over");
    }

    @Test
    public void testGetLink(){
        List<Link> list = mapper.getLink("vipter");
        System.out.println(list);
    }
}