/*
 * Copyright (c) CFCA 2016.
 */

package com.awesomeproject.module.cfca.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderResult {

  @SerializedName("source")
  @Expose
  private String source;
  @SerializedName("sign")
  @Expose
  private String sign;

  /**
   * No args constructor for use in serialization
   */
  public OrderResult() {
  }

  /**
   *
   * @param sign
   * @param source
   */
  public OrderResult(String source, String sign) {
    this.source = source;
    this.sign = sign;
  }

  /**
   * @return The source
   */
  public String getSource() {
    return source;
  }

  /**
   * @param source The source
   */
  public void setSource(String source) {
    this.source = source;
  }

  /**
   * @return The sign
   */
  public String getSign() {
    return sign;
  }

  /**
   * @param sign The sign
   */
  public void setSign(String sign) {
    this.sign = sign;
  }
}
