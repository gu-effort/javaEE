package cdu.gu.springdatajpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pormission")
@Data
public class
SysPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String code;
    @Column
    private String name;
}
