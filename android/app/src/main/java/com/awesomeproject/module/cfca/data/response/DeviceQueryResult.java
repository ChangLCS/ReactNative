/*
 * Copyright (c) CFCA 2016.
 */

package com.awesomeproject.module.cfca.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class DeviceQueryResult {

  @SerializedName("code")
  @Expose
  private String code;
  @SerializedName("desc")
  @Expose
  private String desc;
  @SerializedName("result")
  @Expose
  private List<DeviceResult> deviceResults = new ArrayList<>();

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
  public List<DeviceResult> getQueryResult() {
    return deviceResults;
  }

  /**
   * @param deviceResults The result
   */
  public void setQueryResult(List<DeviceResult> deviceResults) {
    this.deviceResults = deviceResults;
  }
}
