package cdu.gu.springdatajpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Data
public class SysRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String code;
    @Column
    private String name;
    @ManyToMany
    @JoinTable(name = "r_role_permission",
                joinColumns = @JoinColumn(name = "r_id",foreignKey = @ForeignKey(name = "none",value = ConstraintMode.NO_CONSTRAINT)),
               inverseJoinColumns = @JoinColumn(name = "p_id",foreignKey = @ForeignKey(name = "none",value = ConstraintMode.NO_CONSTRAINT)),
                uniqueConstraints = @UniqueConstraint(columnNames = {"r_id","p_id"}))
    private List<SysPermission> sysPermissions;

    @ManyToMany(mappedBy = "roles")
    private List<SysUser> users;
}
