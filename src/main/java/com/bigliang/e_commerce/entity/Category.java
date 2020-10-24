package com.bigliang.e_commerce.entity;

public class Category {

  private long id;
  private String categoryName;
  private String categoryID;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }


  public String getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(String categoryID) {
    this.categoryID = categoryID;
  }

}
