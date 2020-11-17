package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;


@Entity
@Table(name = "permission")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permissionID")
    private int permissionID;

    @Column(name = "actualPermissionID")
    private String actualPermissionID;


    public int getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(int permissionID) {
        this.permissionID = permissionID;
    }

    public String getActualPermissionID() {
        return actualPermissionID;
    }

    public void setActualPermissionID(String actualPermissionID) {
        this.actualPermissionID = actualPermissionID;
    }
}
