package com.csu.community.community.dao;

import com.csu.community.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    //按id查找user
    User selectById(int id);
    //按昵称查找user
    User selectByName(String name);
    //按邮件查找user
    User selectByEmail(String email);
    //插入user，返回成功行数
    int insertUser(User user);
    //修改user状态返回成功行数
    int updateStatus(int id, int status);
    //修改user头像，返回成功行数
    int updateHeaderUrl(int id, String headerUrl);
    //修改用户密码，返回成功行数
    int updatePassword(int id, String password);
}
