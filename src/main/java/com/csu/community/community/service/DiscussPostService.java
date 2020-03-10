package com.csu.community.community.service;

import com.csu.community.community.dao.DiscussPostMapper;
import com.csu.community.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit){
        return discussPostMapper.selectDiscussPosts(userId,offset,limit);
    }

    public int selectDiccussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
