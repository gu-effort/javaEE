package cdu.gu.springdatajpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer number;
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "dep")
    private List<Employee> employeeList;
}
