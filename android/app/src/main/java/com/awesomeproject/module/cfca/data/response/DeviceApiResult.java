/*
 * Copyright (c) CFCA 2016.
 */

package com.awesomeproject.module.cfca.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviceApiResult {

  @SerializedName("code")
  @Expose
  private String code;
  @SerializedName("desc")
  @Expose
  private String desc;
  @SerializedName("result")
  @Expose
  private String result;

  /**
   * No args constructor for use in serialization
   */
  public DeviceApiResult() {
  }

  /**
   *
   * @param result
   * @param desc
   * @param code
   */
  public DeviceApiResult(String code, String desc, String result) {
    this.code = code;
    this.desc = desc;
    this.result = result;
  }

  /**
   * @return The code
   */
  public String getCode() {
    return code;
  }

  /**
   * @param code The code
   */
  public void setCode(String code) {
    this.code = code;
  }

  /**
   * @return The desc
   */
  public String getDesc() {
    return desc;
  }

  /**
   * @param desc The desc
   */
  public void setDesc(String desc) {
    this.desc = desc;
  }

  /**
   * @return The result
   */
  public String getResult() {
    return result;
  }

  /**
   * @param result The result
   */
  public void setResult(String result) {
    this.result = result;
  }
}
