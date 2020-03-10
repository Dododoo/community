package com.csu.community.community;

import com.csu.community.community.dao.UserMapper;
import com.csu.community.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
//@Runwith(SpringRunner.class)
@ContextConfiguration(classes = CommunityApplication.class)
public class Test {
    @Autowired
    private UserMapper userMapper;
    @org.junit.Test
    public void testSelectUser(){
        User user = userMapper.selectById(1);
        System.out.println(user);

    }
}
