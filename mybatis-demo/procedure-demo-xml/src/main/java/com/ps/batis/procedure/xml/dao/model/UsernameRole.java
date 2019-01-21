package com.ps.batis.procedure.xml.dao.model;

public class UsernameRole {
    private String userName;
    private String roleName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UsernameRole{" +
                "username='" + userName + '\'' +
                ", role_name='" + roleName + '\'' +
                '}';
    }
}
