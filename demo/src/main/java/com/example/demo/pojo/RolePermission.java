package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;


@Entity
@Table(name = "rolepermission")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@IdClass(RolePermissioPK.class)
public class RolePermission {
    @Id
    @Column(name = "roleid")
    private int roleid; 

    @Id
    @Column(name = "permissionid")
    private int permissionid;

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(int permissionid) {
        this.permissionid = permissionid;
    }



}
