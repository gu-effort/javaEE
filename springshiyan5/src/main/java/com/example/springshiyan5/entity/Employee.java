package com.example.springshiyan5.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer number;
    @Column
    private String name;
    @Column
    private String gender;
    @Column
    private Integer age;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private Department dep;
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", dep=" + dep +
                '}';
    }

}
