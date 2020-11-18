package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;


@Entity
@Table(name = "rolepermission")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@IdClass(RolePermissioPK.class)
public class RolePermission {
    @Id
    @Column(name = "roleID")
    private int roleID; 

    @Id
    @Column(name = "permissionID")
    private int permissionID; 


    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getPermission() {
        return permissionID;
    }

    public void setPermissionID(int permission) {
        this.permissionID = permission;
    }
}
