package com.qf.springdata_test.controller;

import com.qf.springdata_test.entity.User;
import com.qf.springdata_test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("page/{currentPage}")
    public String getPage(@PathVariable int currentPage, ModelMap map){
        Page<User> p=userService.getPage(currentPage);
        map.put("page",p);
        return "/list";
    }
    @RequestMapping("index")
    public String toIndex(){
        return "redirect:/index.html";
    }
    @RequestMapping("toAdd")
    public String toAdd(){
        return "/add";
    }

    @RequestMapping("add")
    public String add(User user){
        userService.add(user);
        return "redirect:/user/page/1";
    }
    @RequestMapping("del/{id}")
    public String del(@PathVariable int id){
        userService.del(id);
        return "redirect:/user/page/1";
    }
    @RequestMapping("toUpdate/{id}")
    public String toUpdate(@PathVariable int id ,ModelMap map){
        User user=userService.getById(id);
        map.put("user",user);
        return "/update";
    }
    @RequestMapping("update")
    public String update(@PathVariable User user){
        userService.update(user);
        return "redirect:/user/page/1";
    }
}
