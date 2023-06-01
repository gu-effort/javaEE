package com.example.springshiyan5.controller;


import com.example.springshiyan5.entity.Department;
import com.example.springshiyan5.entity.Employee;
import com.example.springshiyan5.service.DepartmentService;
import com.example.springshiyan5.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("emp")
@PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @PreAuthorize("hasAnyRole('EMPLOYEE','MANAGER','ADMIN')")
    @RequestMapping("search")
    public ModelAndView search(Employee condition, @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        ModelAndView mv = new ModelAndView("emp/list");
        List<Department> departmentList = departmentService.findAll();
        Page<List<Employee>> pageInfo = employeeService.findByPage(condition, pageable);

        mv.addObject("pageInfo", pageInfo);
        mv.addObject("depList", departmentList);
        mv.addObject("c", condition);
        return mv;
    }

    @GetMapping("add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView("emp/add");
        List<Department> departmentList = departmentService.findAll();
        mv.addObject("depList", departmentList);
        return mv;
    }

    @PostMapping("add")
    public String add(Employee employee) {
//        if (employeeService.add(employee)) {
        if (employeeService.save(employee)) {
            return "redirect:search";
        } else {
            return "redirect:add";
        }
    }

    @GetMapping("mod")
    public ModelAndView mod(int id) {
        ModelAndView mv = new ModelAndView("emp/mod");
        Employee emp = employeeService.findById(id);
        mv.addObject("emp", emp);
        List<Department> departmentList = departmentService.findAll();
        mv.addObject("depList", departmentList);
        return mv;
    }

    @PostMapping("mod")
    public String mod(Employee employee) {
//        if (employeeService.mod(employee)) {
        if (employeeService.save(employee)) {
            return "redirect:search";
        } else {
            return "redirect:mod";
        }
    }

    @GetMapping("del")
    public String del(int id) {
        employeeService.del(id);
        return "redirect:search";
    }


}
