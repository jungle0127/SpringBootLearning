package com.ps.batis.procedure.dao.model;

public class TUserInfoWithBLOBs extends TUserInfo {
    private byte[] password;

    private byte[] salt;

    private byte[] ispuk;

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

    public byte[] getIspuk() {
        return ispuk;
    }

    public void setIspuk(byte[] ispuk) {
        this.ispuk = ispuk;
    }
}