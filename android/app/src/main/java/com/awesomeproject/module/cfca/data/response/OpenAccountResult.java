/*
 * Copyright (c) CFCA 2016.
 */

package com.awesomeproject.module.cfca.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by wufan on 16/9/5.
 */

public class OpenAccountResult {

  @SerializedName("success")
  @Expose
  private Boolean success;

  /**
   * @return The success
   */
  public Boolean getSuccess() {
    return success;
  }

  /**
   * @param success The success
   */
  public void setSuccess(Boolean success) {
    this.success = success;
  }
}
