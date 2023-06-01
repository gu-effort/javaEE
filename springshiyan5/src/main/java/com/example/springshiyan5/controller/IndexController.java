package com.example.springshiyan5.controller;

import com.example.springshiyan5.entity.SysUser;
import com.example.springshiyan5.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    SysUserService sysUserService;


    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();
        SysUser user = sysUserService.findByUsername(username);
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }
//    @PostMapping("doLogin")
//    public String doLogin(@RequestParam String username,@RequestParam String password){
//        SysUser sysUser=new SysUser();
//        sysUser.setUsername(username);
//        sysUser.setPassword(password);
//        System.out.println(sysUser);
//        System.out.println(sysUserService.find(sysUser));
//        return "loginError";
//    }
    @RequestMapping("loginError")
    public String loginError() {
        return "loginError";
    }
}
