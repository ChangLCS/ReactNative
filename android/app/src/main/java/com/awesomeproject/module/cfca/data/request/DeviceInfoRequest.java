/*
 * Copyright (c) CFCA 2016.
 */

package com.awesomeproject.module.cfca.data.request;

import com.awesomeproject.module.cfca.data.response.Device1;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviceInfoRequest {

  @SerializedName("deviceInfo")
  @Expose
  private Device1 device1;
  @SerializedName("deviceType")
  @Expose
  private String deviceType;
  @SerializedName("phoneNo")
  @Expose
  private String phoneNo;
  @SerializedName("idNo")
  @Expose
  private String idNo;
  @SerializedName("name")
  @Expose
  private String name;

  /**
   * No args constructor for use in serialization
   */
  public DeviceInfoRequest() {
  }

  /**
   *
   * @param idNo
   * @param phoneNo
   * @param deviceType
   * @param name
   * @param device1
   */
  public DeviceInfoRequest(Device1 device1, String deviceType, String phoneNo, String idNo,
      String name) {
    this.device1 = device1;
    this.deviceType = deviceType;
    this.phoneNo = phoneNo;
    this.idNo = idNo;
    this.name = name;
  }

  /**
   * @return The deviceInfo
   */
  public Device1 getDevice1() {
    return device1;
  }

  /**
   * @param device1 The deviceInfo
   */
  public void setDevice1(Device1 device1) {
    this.device1 = device1;
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
}
