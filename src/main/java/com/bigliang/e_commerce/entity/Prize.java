package com.bigliang.e_commerce.entity;


public class Prize {

  private String prizeID;
  private String prizeName;
  private int prizeLevel;
  private String prizeType;
  private int prizeCount;
  private String referenceTo;

  private int startCode;
  private int endCode;
  private double prizeWeight;
  private int hitCode;

  public int getHitCode() {
    return hitCode;
  }

  public void setHitCode(int hitCode) {
    this.hitCode = hitCode;
  }

  public int getStartCode() {
    return startCode;
  }

  public void setStartCode(int startCode) {
    this.startCode = startCode;
  }

  public int getEndCode() {
    return endCode;
  }

  public void setEndCode(int endCode) {
    this.endCode = endCode;
  }

  public double getPrizeWeight() {
    return prizeWeight;
  }

  public void setPrizeWeight(double prizeWeight) {
    this.prizeWeight = prizeWeight;
  }

  public String getPrizeId() {
    return prizeID;
  }

  public void setPrizeId(String prizeID) {
    this.prizeID = prizeID;
  }


  public String getPrizeName() {
    return prizeName;
  }

  public void setPrizeName(String prizeName) {
    this.prizeName = prizeName;
  }


  public int getPrizeLevel() {
    return prizeLevel;
  }

  public void setPrizeLevel(int prizeLevel) {
    this.prizeLevel = prizeLevel;
  }


  public String getPrizeType() {
    return prizeType;
  }

  public void setPrizeType(String prizeType) {
    this.prizeType = prizeType;
  }


  public int getPrizeCount() {
    return prizeCount;
  }

  public void setPrizeCount(int prizeCount) {
    this.prizeCount = prizeCount;
  }


  public String getReferenceTo() {
    return referenceTo;
  }

  public void setReferenceTo(String referenceTo) {
    this.referenceTo = referenceTo;
  }

}
