package com.example.springshiyan5.entity;

import java.util.List;

public class Department {
    private Integer id;
    private String name;
    private Integer number;
    private List<Employee> employeeList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", employeeList=" + employeeList +
                '}';
    }

    public Department(Integer id, String name, Integer number, List<Employee> employeeList) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.employeeList = employeeList;
    }
}
