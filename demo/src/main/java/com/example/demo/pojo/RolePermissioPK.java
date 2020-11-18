package com.example.demo.pojo;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class RolePermissioPK implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int roleID;
    private Permission permission;

    @Override
    public boolean equals(Object o){
        if( this ==o) return true;
        if(!(o instanceof RolePermissioPK)) return false;

        RolePermissioPK rolePermissioPK = (RolePermissioPK) o;

        if(roleID != rolePermissioPK.getRoleID()) return false;
        return permission != rolePermissioPK.getPermission();
    }

    @Override
    public int hashCode(){
        int result = roleID;
        result = result*31+permission.hashCode();
        return result;
    }

    private Permission getPermission() {
        return permission;
    }

    private int getRoleID() {
        return roleID;
    }

 

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }



    public void setPermissionID(Permission permission) {
        this.permission = permission;
    }

}
