package com.example.springshiyan5.controller;

import com.example.springshiyan5.entity.Department;
import com.example.springshiyan5.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("dep")
public class DepartmentController {
    @Resource
    DepartmentService departmentService;

    @RequestMapping("search")
    public ModelAndView search(Department condition, @RequestParam(defaultValue = "1") int pageNo){
        ModelAndView mv=new ModelAndView("dep/list");
        PageHelper.startPage(pageNo, 10);
        List<Department> departmentList=departmentService.find(condition);
        PageInfo pageInfo=new PageInfo<>(departmentList);

        mv.addObject("depList",departmentList);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("c",condition);
        return mv;
    }

    @GetMapping("add")
    public String add(){
        return "dep/add";
    }
    @PostMapping("add")
    public String add(Department department){
        if (departmentService.add(department)){
            return "redirect:search";
        }else {
            return "redirect:add";
        }
    }
    @GetMapping("mod")
    public ModelAndView mod(int id){
        ModelAndView mv=new ModelAndView("dep/mod");
        Department department=departmentService.findById(id);
        mv.addObject("dep",department);
        return mv;
    }

    @PostMapping("mod")
    public String mod(Department department){
        if (departmentService.mod(department)){
            return "redirect:search";
        }else {
            return "redirect:mod";
        }
    }

    @GetMapping("del")
    public String del(int id){
        departmentService.del(id);
        return "redirect:search";
    }
}
