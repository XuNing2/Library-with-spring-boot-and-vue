package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;


@Entity
@Table(name = "rolepermission")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@IdClass(RolePermissioPK.class)
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleID")
    private int roleID; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permissionID")
    private int permission; 


    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermissionID(int permission) {
        this.permission = permission;
    }
}
