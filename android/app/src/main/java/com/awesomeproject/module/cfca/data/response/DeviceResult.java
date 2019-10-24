/*
 * Copyright (c) CFCA 2016.
 */

package com.awesomeproject.module.cfca.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by wufan on 16/3/31.
 */
public class DeviceResult {
  @SerializedName("deviceInfo")
  @Expose
  private Device1 deviceInfo;
  @SerializedName("deviceType")
  @Expose
  private String deviceType;
  @SerializedName("deviceTag")
  @Expose
  private String deviceTag;
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
   * No args constructor for use in serialization
   */
  public DeviceResult() {
  }

  /**
   *
   * @param deviceTag
   * @param deviceType
   * @param deviceInfo
   */
  public DeviceResult(Device1 deviceInfo, String deviceType, String deviceTag) {
    this.deviceInfo = deviceInfo;
    this.deviceType = deviceType;
    this.deviceTag = deviceTag;
  }

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
   * @return The deviceTag
   */
  public String getDeviceTag() {
    return deviceTag;
  }

  /**
   * @param deviceTag The deviceTag
   */
  public void setDeviceTag(String deviceTag) {
    this.deviceTag = deviceTag;
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
