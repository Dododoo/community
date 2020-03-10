package com.csu.community.community.dao;

import com.csu.community.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface DiscussPostMapper {
    //查看我发布的帖子（userId = 0时表示查看所有帖子,offset起始行的行号，limit每页多少行）
    List<DiscussPost> selectDiscussPosts(int userId,int offset, int limit);

    //使用@param原因是在sql里需要用到动态的条件时
    /*@param为参数取别名
    * 在方法中需要动态添加参数且有且只有一个参数时，并且需要在sql语句的<if>里面使用，必须要为参数取别名@Param("")
    * */
    int selectDiscussPostRows(@Param("userId")int userId);
}
