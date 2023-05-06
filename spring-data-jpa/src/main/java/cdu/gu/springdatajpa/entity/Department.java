package cdu.gu.springdatajpa.entity;

import lombok.Data;

import javax.persistence.*;

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
}
