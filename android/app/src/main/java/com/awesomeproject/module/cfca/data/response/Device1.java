/*
 * Copyright (c) CFCA 2016.
 */

package com.awesomeproject.module.cfca.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Device1 {

  @SerializedName(value = "installation", alternate = { "vendorID" })
  @Expose
  private String uniqueIdentifies1;
  @SerializedName(value = "mac", alternate = { "advertisingID" })
  @Expose
  private String uniqueIdentifies2;
  @SerializedName("manufacturer")
  @Expose
  private String manufacturer;
  @SerializedName("modelName")
  @Expose
  private String modelName;
  @SerializedName("brand")
  @Expose
  private String brand;
  @SerializedName("systemVersion")
  @Expose
  private String systemVersion;

  /**
   * No args constructor for use in serialization
   */
  public Device1() {
  }

  /**
   *
   * @param modelName
   * @param systemVersion
   * @param manufacturer
   * @param uniqueIdentifies1
   * @param brand
   * @param uniqueIdentifies2
   */
  public Device1(String uniqueIdentifies1, String uniqueIdentifies2, String manufacturer,
      String modelName, String brand, String systemVersion) {
    this.uniqueIdentifies1 = uniqueIdentifies1;
    this.uniqueIdentifies2 = uniqueIdentifies2;
    this.manufacturer = manufacturer;
    this.modelName = modelName;
    this.brand = brand;
    this.systemVersion = systemVersion;
  }

  /**
   * @return The ime
   */
  public String getUniqueIdentifies1() {
    return uniqueIdentifies1;
  }

  /**
   * @param uniqueIdentifies1 The ime
   */
  public void setUniqueIdentifies1(String uniqueIdentifies1) {
    this.uniqueIdentifies1 = uniqueIdentifies1;
  }

  /**
   * @return The ma
   */
  public String getUniqueIdentifies2() {
    return uniqueIdentifies2;
  }

  /**
   * @param uniqueIdentifies2 The ma
   */
  public void setUniqueIdentifies2(String uniqueIdentifies2) {
    this.uniqueIdentifies2 = uniqueIdentifies2;
  }

  /**
   * @return The manufacturer
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * @param manufacturer The manufacturer
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * @return The modelName
   */
  public String getModelName() {
    return modelName;
  }

  /**
   * @param modelName The modelName
   */
  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  /**
   * @return The brand
   */
  public String getBrand() {
    return brand;
  }

  /**
   * @param brand The brand
   */
  public void setBrand(String brand) {
    this.brand = brand;
  }

  /**
   * @return The systemVersion
   */
  public String getSystemVersion() {
    return systemVersion;
  }

  /**
   * @param systemVersion The systemVersion
   */
  public void setSystemVersion(String systemVersion) {
    this.systemVersion = systemVersion;
  }
}
