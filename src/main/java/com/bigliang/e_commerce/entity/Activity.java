package com.bigliang.e_commerce.entity;


import java.sql.Timestamp;

public class Activity {

  private String actID;
  private String actName;
  private int actType;
  private long limited;
  private String actDescribe;
  private int actStatus;
  private String wayOfAwarding;
  private Timestamp startTime;
  private Timestamp endTime;


  public String getActID() {
    return actID;
  }

  public void setActID(String actID) {
    this.actID = actID;
  }

  public String getActName() {
    return actName;
  }

  public void setActName(String actName) {
    this.actName = actName;
  }


  public int getActType() {
    return actType;
  }

  public void setActType(int actType) {
    this.actType = actType;
  }


  public long getLimited() {
    return limited;
  }

  public void setLimited(long limited) {
    this.limited = limited;
  }


  public String getActDescribe() {
    return actDescribe;
  }

  public void setActDescribe(String actDescribe) {
    this.actDescribe = actDescribe;
  }


  public int getActStatus() {
    return actStatus;
  }

  public void setActStatus(int actStatus) {
    this.actStatus = actStatus;
  }


  public String getWayOfAwarding() {
    return wayOfAwarding;
  }

  public void setWayOfAwarding(String wayOfAwarding) {
    this.wayOfAwarding = wayOfAwarding;
  }


  public Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(Timestamp startTime) {
    this.startTime = startTime;
  }


  public Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(Timestamp endTime) {
    this.endTime = endTime;
  }

}
