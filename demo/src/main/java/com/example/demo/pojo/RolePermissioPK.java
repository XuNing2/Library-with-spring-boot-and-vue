package com.example.demo.pojo;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class RolePermissioPK implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int roleid;
    private int permissionid;

    @Override
    public boolean equals(Object o){
        if( this ==o) return true;
        if(!(o instanceof RolePermissioPK)) return false;

        RolePermissioPK rolePermissioPK = (RolePermissioPK) o;

        if(roleid != rolePermissioPK.getRoleID()) return false;
        return permissionid != rolePermissioPK.getPermission();
    }

    @Override
    public int hashCode(){
        int result = roleid;
        result = result*31+permissionid;
        return result;
    }

    private int getPermission() {
        return permissionid;
    }

    private int getRoleID() {
        return roleid;
    }

 

    public void setRoleID(int roleID) {
        this.roleid = roleID;
    }



    public void setPermissionID(int permission) {
        this.permissionid = permission;
    }

}
