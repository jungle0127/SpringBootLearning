package com.ps.batis.procedure.dao.model;

public class TAdminWithBLOBs extends TAdmin {
    private byte[] password;

    private byte[] salt;

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}