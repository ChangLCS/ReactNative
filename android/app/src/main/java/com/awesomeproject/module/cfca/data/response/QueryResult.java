/*
 * Copyright (c) CFCA 2016.
 */

package com.awesomeproject.module.cfca.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QueryResult {

  @SerializedName("deviceInfo")
  @Expose
  private Device1 deviceInfo;
  @SerializedName("deviceType")
  @Expose
  private String deviceType;
  @SerializedName("idNo")
  @Expose
  private String idNo;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("phoneNo")
  @Expose
  private String phoneNo;

  /**
   * @return The deviceInfo
   */
  public Device1 getDeviceInfo() {
    return deviceInfo;
  }

  /**
   * @param deviceInfo The deviceInfo
   */
  public void setDeviceInfo(Device1 deviceInfo) {
    this.deviceInfo = deviceInfo;
  }

  /**
   * @return The deviceType
   */
  public String getDeviceType() {
    return deviceType;
  }

  /**
   * @param deviceType The deviceType
   */
  public void setDeviceType(String deviceType) {
    this.deviceType = deviceType;
  }

  /**
   * @return The idNo
   */
  public String getIdNo() {
    return idNo;
  }

  /**
   * @param idNo The idNo
   */
  public void setIdNo(String idNo) {
    this.idNo = idNo;
  }

  /**
   * @return The name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name The name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return The phoneNo
   */
  public String getPhoneNo() {
    return phoneNo;
  }

  /**
   * @param phoneNo The phoneNo
   */
  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }
}
