package com.example.springshiyan5.controller;

import com.example.springshiyan5.entity.Department;
import com.example.springshiyan5.entity.Employee;
import com.example.springshiyan5.service.DepartmentService;
import com.example.springshiyan5.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("dep")
@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("search")
    public ModelAndView search(Department condition, @PageableDefault(page = 0, size = 5, sort = "id",
            direction = Sort.Direction.ASC) Pageable pageable) {
        ModelAndView mv = new ModelAndView("dep/list");
        Page<List<Department>> pageInfo = departmentService.findByPage(condition, pageable);

        mv.addObject("pageInfo", pageInfo);
        mv.addObject("c", condition);
        return mv;
    }

    //    @RequestMapping("search")
//    public ModelAndView search(Department condition) {
//        ModelAndView mv = new ModelAndView("dep/list");
//        List<Department> departmentList = departmentService.find(condition);
//
//        mv.addObject("depList", departmentList);
//        mv.addObject("c", condition);
//        return mv;
//    }

    @GetMapping("add")
    public String add() {
        return "dep/add";
    }

    @PostMapping("add")
    public String add(Department department) {
        if (departmentService.add(department)) {
            return "redirect:search";
        } else {
            return "redirect:add";
        }
    }

    @GetMapping("mod")
    public ModelAndView mod(int id) {
        ModelAndView mv = new ModelAndView("dep/mod");
        Department department = departmentService.findById(id);
        mv.addObject("dep", department);
        return mv;
    }

    @PostMapping("mod")
    public String mod(Department department) {
        if (departmentService.mod(department)) {
            return "redirect:search";
        } else {
            return "redirect:mod";
        }
    }

    @GetMapping("del")
    public String del(int id) {
        departmentService.del(id);
        return "redirect:search";
    }

}
