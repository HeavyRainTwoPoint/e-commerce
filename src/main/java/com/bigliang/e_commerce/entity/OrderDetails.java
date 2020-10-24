package com.bigliang.e_commerce.entity;


public class OrderDetails {

  private long id;
  private String orderID;
  private String goodsID;
  private long count;

  public OrderDetails() {}

  public OrderDetails(String orderID, String goodsID, long count) {
    this.orderID = orderID;
    this.goodsID = goodsID;
    this.count = count;
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

  public String getGoodsID() {
    return goodsID;
  }

  public void setGoodsID(String goodsID) {
    this.goodsID = goodsID;
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }

}
