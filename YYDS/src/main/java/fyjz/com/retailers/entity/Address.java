package fyjz.com.retailers.entity;

import java.util.Date;

public class Address {
    private Integer id;

    private Integer uid;

    private String recvUsername;

    private String recvProvincecode;

    private String recvCitycode;

    private String recvAreacode;

    private String recvDistrict;

    private String recvAddress;

    private String recvPhone;

    private String recvTel;

    private String recvZip;

    private String recvTag;

    private Integer isDefault;

    private String createUser;

    private Date createTime;

    private String modifiedUser;

    private Date modifiedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRecvUsername() {
        return recvUsername;
    }

    public void setRecvUsername(String recvUsername) {
        this.recvUsername = recvUsername == null ? null : recvUsername.trim();
    }

    public String getRecvProvincecode() {
        return recvProvincecode;
    }

    public void setRecvProvincecode(String recvProvincecode) {
        this.recvProvincecode = recvProvincecode == null ? null : recvProvincecode.trim();
    }

    public String getRecvCitycode() {
        return recvCitycode;
    }

    public void setRecvCitycode(String recvCitycode) {
        this.recvCitycode = recvCitycode == null ? null : recvCitycode.trim();
    }

    public String getRecvAreacode() {
        return recvAreacode;
    }

    public void setRecvAreacode(String recvAreacode) {
        this.recvAreacode = recvAreacode == null ? null : recvAreacode.trim();
    }

    public String getRecvDistrict() {
        return recvDistrict;
    }

    public void setRecvDistrict(String recvDistrict) {
        this.recvDistrict = recvDistrict == null ? null : recvDistrict.trim();
    }

    public String getRecvAddress() {
        return recvAddress;
    }

    public void setRecvAddress(String recvAddress) {
        this.recvAddress = recvAddress == null ? null : recvAddress.trim();
    }

    public String getRecvPhone() {
        return recvPhone;
    }

    public void setRecvPhone(String recvPhone) {
        this.recvPhone = recvPhone == null ? null : recvPhone.trim();
    }

    public String getRecvTel() {
        return recvTel;
    }

    public void setRecvTel(String recvTel) {
        this.recvTel = recvTel == null ? null : recvTel.trim();
    }

    public String getRecvZip() {
        return recvZip;
    }

    public void setRecvZip(String recvZip) {
        this.recvZip = recvZip == null ? null : recvZip.trim();
    }

    public String getRecvTag() {
        return recvTag;
    }

    public void setRecvTag(String recvTag) {
        this.recvTag = recvTag == null ? null : recvTag.trim();
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser == null ? null : modifiedUser.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}