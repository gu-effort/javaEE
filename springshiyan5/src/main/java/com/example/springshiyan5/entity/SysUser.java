package com.example.springshiyan5.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;

    @ManyToMany
    @OrderBy("id asc")
    @JoinTable(name = "r_user_role",
            joinColumns = @JoinColumn(name = "u_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT)),
            inverseJoinColumns = @JoinColumn(name = "r_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT)),
            uniqueConstraints = @UniqueConstraint(columnNames = {"u_id", "r_id"}))
    private List<SysRole> roles;

    @Transient
    private SysRole role;

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + Arrays.toString(roles.toArray()) +
                '}';
    }

}
