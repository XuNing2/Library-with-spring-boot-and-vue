package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;


@Entity
@Table(name = "permission")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permissionid")
    private int permissionid;

    @Column(name = "actualpermissionid")
    private String actualpermissionid;

    public Permission(int permissionid, String path){
        this.permissionid = permissionid;
        this.actualpermissionid = path;
    }

    public int getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(int permissionid) {
        this.permissionid = permissionid;
    }

    public String getActualpermissionid() {
        return actualpermissionid;
    }

    public void setActualpermissionid(String actualpermissionid) {
        this.actualpermissionid = actualpermissionid;
    }



}
