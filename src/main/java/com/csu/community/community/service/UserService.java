package com.csu.community.community.service;

import com.csu.community.community.dao.UserMapper;
import com.csu.community.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User selectById(int id){
        return userMapper.selectById(id);
    }
}
