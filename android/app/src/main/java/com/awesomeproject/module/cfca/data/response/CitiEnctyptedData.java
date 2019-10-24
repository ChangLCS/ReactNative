package com.awesomeproject.module.cfca.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cfca on 2018/3/5.
 */

public class CitiEnctyptedData {
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("idType")
  @Expose
  private String idType;
  @SerializedName("idNum")
  @Expose
  private String idNum;
  @SerializedName("phoneNo")
  @Expose
  private String phoneNo;
  @SerializedName("encryptedSensitiveKey")
  @Expose
  private String encryptedSensitiveKey;
  @SerializedName("authInfo")
  @Expose
  private String authInfo;
  @SerializedName("deviceInfoProvidedByOrg")
  @Expose
  private String deviceInfoProvidedByOrg;

  /**
   * No args constructor for use in serialization
   */
  public CitiEnctyptedData() {
  }

  public CitiEnctyptedData(String name, String idType, String idNum, String phoneNo,
      String encryptedSensitiveKey, String deviceInfoProvidedByOrg) {
    this.name = name;
    this.idType = idType;
    this.idNum = idNum;
    this.phoneNo = phoneNo;
    this.encryptedSensitiveKey = encryptedSensitiveKey;
    this.deviceInfoProvidedByOrg = deviceInfoProvidedByOrg;
  }

  public String getDeviceInfoProvidedByOrg() {
    return deviceInfoProvidedByOrg;
  }

  public String getName() {
    return name;
  }

  public String getIdType() {
    return idType;
  }

  public String getIdNum() {
    return idNum;
  }

  public String getPhoneNo() {
    return phoneNo;
  }

  public String getAuthInfo() {
    return authInfo;
  }

  public String getEncryptedSensitiveKey() {
    return encryptedSensitiveKey;
  }
}
