/*
 * Copyright (c) CFCA 2016.
 */

package com.awesomeproject.module.cfca.data.model;

import com.awesomeproject.module.cfca.data.response.DeviceResult;

/**
 * Created by wufan on 16/3/31.
 */
public class Device {
  private final String deviceName;
  private final String deviceTag;

  public Device(String deviceName, String deviceTag) {
    this.deviceName = deviceName;
    this.deviceTag = deviceTag;
  }

  public static Device fromDeviceResult(DeviceResult deviceResult) {
    return new Device(deviceResult.getDeviceInfo().getModelName(), deviceResult.getDeviceTag());
  }

  public String getDeviceName() {
    return deviceName;
  }

  public String getDeviceTag() {
    return deviceTag;
  }
}
