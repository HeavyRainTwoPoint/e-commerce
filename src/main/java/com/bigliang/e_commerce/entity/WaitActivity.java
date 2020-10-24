package com.bigliang.e_commerce.entity;


public class WaitActivity {

  private long id;
  private String userId;
  private String actId;
  private java.sql.Timestamp joinTime;

  public WaitActivity(String userId, String actId) {
    this.userId = userId;
    this.actId = actId;
  }

  public WaitActivity(){};

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getActId() {
    return actId;
  }

  public void setActId(String actId) {
    this.actId = actId;
  }


  public java.sql.Timestamp getJoinTime() {
    return joinTime;
  }

  public void setJoinTime(java.sql.Timestamp joinTime) {
    this.joinTime = joinTime;
  }

}
