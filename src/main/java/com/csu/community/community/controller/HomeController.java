package com.csu.community.community.controller;


import com.csu.community.community.entity.DiscussPost;
import com.csu.community.community.entity.Page;
import com.csu.community.community.entity.User;
import com.csu.community.community.service.DiscussPostService;
import com.csu.community.community.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import sun.jvm.hotspot.debugger.Page;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping("/select")
    @ResponseBody
    public User selectByUserId(@Param("id") int id){
        return userService.selectById(id);
    }

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {
        // 方法调用钱,SpringMVC会自动实例化Model和Page,并将Page注入Model.
        // 所以,在thymeleaf中可以直接访问Page对象中的数据.
        page.setRows(discussPostService.selectDiccussPostRows(103));
        page.setPath("/index");
        model.addAttribute("page",page);
        List<DiscussPost> list = discussPostService.selectDiscussPosts(103, page.getOffset(), page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.selectById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        //return list.toString();
        return "/index";
    }

}
