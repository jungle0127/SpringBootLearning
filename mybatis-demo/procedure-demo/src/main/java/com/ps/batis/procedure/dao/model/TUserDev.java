package com.ps.batis.procedure.dao.model;

import java.util.Date;

public class TUserDev {
    private String deviceId;

    private String id;

    private String userId;

    private String deviceAlias;

    private String osName;

    private String terminalName;

    private Date createTime;

    private String userDeviceKeysNodeId;

    private Integer deleted;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDeviceAlias() {
        return deviceAlias;
    }

    public void setDeviceAlias(String deviceAlias) {
        this.deviceAlias = deviceAlias == null ? null : deviceAlias.trim();
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName == null ? null : osName.trim();
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName == null ? null : terminalName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserDeviceKeysNodeId() {
        return userDeviceKeysNodeId;
    }

    public void setUserDeviceKeysNodeId(String userDeviceKeysNodeId) {
        this.userDeviceKeysNodeId = userDeviceKeysNodeId == null ? null : userDeviceKeysNodeId.trim();
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}