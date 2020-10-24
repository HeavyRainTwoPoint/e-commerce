package com.bigliang.e_commerce.entity;


public class Goods {

  private long id;
  private String goodsID;
  private String goodsName;
  private String goodsCount;
  private double goodsPrice;
  private String goodsDescribe;
  private long goodsStatus;
  private String goodsUnit;
  private String referToBrand;
  private String categoryID;
  private String categoryName;
  private int count;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getGoodsID() {
    return goodsID;
  }

  public void setGoodsID(String goodsID) {
    this.goodsID = goodsID;
  }


  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }


  public String getGoodsCount() {
    return goodsCount;
  }

  public void setGoodsCount(String goodsCount) {
    this.goodsCount = goodsCount;
  }


  public double getGoodsPrice() {
    return goodsPrice;
  }

  public void setGoodsPrice(double goodsPrice) {
    this.goodsPrice = goodsPrice;
  }


  public String getGoodsDescribe() {
    return goodsDescribe;
  }

  public void setGoodsDescribe(String goodsDescribe) {
    this.goodsDescribe = goodsDescribe;
  }


  public long getGoodsStatus() {
    return goodsStatus;
  }

  public void setGoodsStatus(long goodsStatus) {
    this.goodsStatus = goodsStatus;
  }


  public String getGoodsUnit() {
    return goodsUnit;
  }

  public void setGoodsUnit(String goodsUnit) {
    this.goodsUnit = goodsUnit;
  }


  public String getReferToBrand() {
    return referToBrand;
  }

  public void setReferToBrand(String referToBrand) {
    this.referToBrand = referToBrand;
  }


  public String getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(String categoryID) {
    this.categoryID = categoryID;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getCount() {
    return this.count;
  }
}
