package com.example.springshiyan5.controller;


import com.example.springshiyan5.entity.SysRole;
import com.example.springshiyan5.entity.SysUser;
import com.example.springshiyan5.service.SysRoleService;
import com.example.springshiyan5.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
@PreAuthorize("hasRole('ADMIN')")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysRoleService sysRoleService;


    @RequestMapping("search")
    public ModelAndView search(SysUser condition, @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        ModelAndView mv = new ModelAndView("user/list");
        List<SysRole> roleList = sysRoleService.findAll();
        Page<List<SysUser>> pageInfo = sysUserService.findByPage(condition, pageable);

        mv.addObject("pageInfo", pageInfo);
        mv.addObject("roleList", roleList);
        mv.addObject("c", condition);
        return mv;
    }

    @GetMapping("add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView("user/add");
        List<SysRole> roleList = sysRoleService.findAll();
        mv.addObject("roleList", roleList);
        return mv;
    }

    //    @PostMapping("add")
    @GetMapping("add1")
    public String add(SysUser sysUser) {
        if (sysUserService.add(sysUser)) {
            return "redirect:search";
        } else {
            return "redirect:add";
        }
    }

    @GetMapping("mod")
    public ModelAndView mod(int id) {
        ModelAndView mv = new ModelAndView("user/mod");
        SysUser user = sysUserService.findById(id);
        mv.addObject("user", user);
        List<SysRole> roleList = sysRoleService.findAll();
        mv.addObject("roleList", roleList);
        return mv;
    }

    //    @PostMapping("mod")
    @GetMapping("mod1")
    public String mod(SysUser sysUser) {
        if (sysUserService.mod(sysUser)) {
            return "redirect:search";
        } else {
            return "redirect:mod";
        }
    }

    @GetMapping("del")
    public String del(int id) {
        sysUserService.del(id);
        return "redirect:search";
    }

    @GetMapping("resetPwd")
    public String resetPwd(int id) {
        sysUserService.resetPwd(id);
        return "redirect:search";
    }


}
