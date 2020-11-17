package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;


@Entity
@Table(name = "role")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleID")
    private int roleID; 


    @Column(name = "permissionID")
    private Permission permission; 

    @Column(name = "roleName")
    private String roleName;

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public Permission getPermissionID() {
        return permission;
    }

    public void setPermissionID(Permission permission) {
        this.permission = permission;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
