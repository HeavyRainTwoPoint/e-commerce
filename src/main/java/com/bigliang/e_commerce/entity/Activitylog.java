package com.bigliang.e_commerce.entity;


public class Activitylog {

  private long id;
  private String userId;
  private String actId;
  private String prizeId;
  private java.sql.Timestamp hitTime;

  public Activitylog(String userId, String actId, String prizeId) {
    this.actId = actId;
    this.userId = userId;
    this.prizeId = prizeId;
  }
  public Activitylog(){};

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


  public String getPrizeId() {
    return prizeId;
  }

  public void setPrizeId(String prizeId) {
    this.prizeId = prizeId;
  }


  public java.sql.Timestamp getHitTime() {
    return hitTime;
  }

  public void setHitTime(java.sql.Timestamp hitTime) {
    this.hitTime = hitTime;
  }

}
