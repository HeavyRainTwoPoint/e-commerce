package com.bigliang.e_commerce.entity;


import java.sql.Timestamp;

public class User {

  private String userID;
  private String userNickname;
  private String loginAccount;
  private String password;
  private String address;
  private java.sql.Timestamp birthday;
  private String loginCount;
  private String imagePath;
  private long identity;
  private Timestamp registeTime;


  public String getUserNickname() {
    return userNickname;
  }

  public void setUserNickname(String userNickname) {
    this.userNickname = userNickname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public Timestamp getBirthday() {
    return birthday;
  }

  public void setBirthday(Timestamp birthday) {
    this.birthday = birthday;
  }


  public String getLoginCount() {
    return loginCount;
  }

  public void setLoginCount(String loginCount) {
    this.loginCount = loginCount;
  }


  public String getImagePath() {
    return imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }


  public java.sql.Timestamp getRegisteTime() {
    return registeTime;
  }

  public void setRegisteTime(java.sql.Timestamp registeTime) {
    this.registeTime = registeTime;
  }

  public String getUserID() {
    return userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public String getLoginAccount() {
    return loginAccount;
  }

  public void setLoginAccount(String loginAccount) {
    this.loginAccount = loginAccount;
  }

  public long getIdentity() {
    return identity;
  }

  public void setIdentity(long identity) {
    this.identity = identity;
  }
}
