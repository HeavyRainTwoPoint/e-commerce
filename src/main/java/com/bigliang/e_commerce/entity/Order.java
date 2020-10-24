package com.bigliang.e_commerce.entity;


import java.sql.Timestamp;

public class Order {

  private long id;
  private String orderID;
  private String userID;
  private Timestamp createTime;
  private long orderStatus;

  public Order(){};

  public Order(String orderID, String userID, long orderStatus) {
    this.orderID = orderID;
    this.userID = userID;
    this.orderStatus = orderStatus;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getOrderID() {
    return orderID;
  }

  public void setOrderID(String orderID) {
    this.orderID = orderID;
  }

  public String getUserID() {
    return userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }


  public long getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(long orderStatus) {
    this.orderStatus = orderStatus;
  }

}
