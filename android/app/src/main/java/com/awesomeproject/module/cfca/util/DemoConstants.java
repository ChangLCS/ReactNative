/*
 * Copyright (c) CFCA 2016.
 */

package com.awesomeproject.module.cfca.util;

import android.support.annotation.IntDef;

/**
 * Created by wufan on 16/3/29.
 */
public final class DemoConstants {

  private DemoConstants() {
  }

  public static final String SERVER_RANDOM = "SERVER_RANDOM";
  public static final String SERVER_RANDOM_SIGNATURE = "SERVER_RANDOM_SIGNATURE";
  public static final String SUCCESS = "SUCCESS";
  public static final String MESSAGE = "MESSAGE";

  public static final String ACTION_SIGN = "cn.com.cfca.hke_sdk.ACTION.SIGN";
  public static final String ACTION_SIGN_HUISHANG = "cn.com.cfca.hke_sdk.ACTION.SIGN.HUISHANG";
  public static final String ACTION_REVOKE = "cn.com.cfca.hke_sdk.ACTION.REVOKE";

  public static final int SIGN_CODE = 100;
  public static final int RESULT_CODE = 200;
  public static final int REVOKE_CODE = 300;

  public static final String DEVICE_ANDROID = "1";

  public static final String PREFERENCES_KEY = "PREFERENCES_KEY";
  public static final String PHONE_EDITOR_KEY = "PHONE_KEY";
  public static final String NAME_EDITOR_KEY = "NAME_KEY";
  public static final String IDNO_EDITOR_KEY = "IDNO_KEY";
  public static final String IDTYPE_EDITOR_KEY = "IDTYPE_KEY";
  public static final String DEVICE_TAG_EDITOR_KEY = "DEVICE_TAG_KEY";
  public static final String ENDPOINT_KEY = "ENDPOINT_KEY";
  public static final String ENTERPRISE_KEY = "ENTERPRISE_KEY";
  public static final String IFAA_KEY = "IFAA_KEY";
  public static final String REVOKED_DEVICE_TAG_EDITOR_KEY = "REVOKED_DEVICE_TAG_EDITOR_KEY";
  public static final String HKE_ENDPOINT_KEY = "HKE_ENDPOINT_KEY";
  public static final String PIN_SERVERRANDOM_KEY = "HKE_PIN_SERVERRANDOM_KEY";
  public static final String HKE_PIN_STATE_KEY = "HKE_PIN_STATE_KEY";
  public static final String SERVERRANDOM_KEY = "HKE_SERVERRANDOM_KEY";
  public static final String IS_CITI_TEST = "IS_CITI_TEST";
  public static final String IS_IFAA_TEST = "IS_IFAA_TEST";
  public static final String SERVER_FINGERPRINT_STATE_KEY = "SERVER_FINGERPRINT_STATE_KEY";
  public static final String REACTIVATE_FINGERPRINT_KEY = "REACTIVATE_FINGERPRINT_KEY";
  public static final String OLD_AUTHENTICATE_KEY = "OLD_AUTHENTICATE_KEY";
  public static final String EXTENSION_KEY = "EXTENSION_KEY";
  public static final String USE_EXTENSION_KEY = "USE_EXTENSION_KEY";

  public static final int HKE_PIN_STATE_DISABLE = 0; //PIN is disable, can not use and set
  public static final int HKE_PIN_STATE_NOT_SET = 1;
  //PIN is enable, but not set.Should set before use
  public static final int HKE_PIN_STATE_HAVE_SET = 2; //PIN is enable and have been set.
  public static final int HKE_PIN_STATE_LOCKED = 3; //PIN is enable and setted, but locked today.
  public static final int HKE_PIN_STATE_LOCKED_FOREVER = 4;//PIN is locked forever

  public static final String SERVICE_TYPE = "SERVICE_TYPE";
  public static final String ORG_APP_TYPE = "ORG_APP_TYPE";

  @IntDef({ SIGN_WAY_NO_PASSWORD, SIGN_WAY_WITH_PASSWORD, SIGN_WAY_WITH_FINGERPRINT })
  public @interface SignWay {
  }

  public static final int SIGN_WAY_NO_PASSWORD = 0;
  public static final int SIGN_WAY_WITH_PASSWORD = 1;
  public static final int SIGN_WAY_WITH_FINGERPRINT = 2;

  @IntDef({ ENVELOPE_WAY_NO_PASSWORD, ENVELOPE_WAY_PASSWORD, ENVELOPE_WAY_FINGERPRINT })
  public @interface EnvelopeWay {

  }

  public static final int ENVELOPE_WAY_NO_PASSWORD = 0;
  public static final int ENVELOPE_WAY_PASSWORD = 1;
  public static final int ENVELOPE_WAY_FINGERPRINT = 2;

  public static final String TEST_ORG_ID = "HKE_TEST_ORG";
  public static final String TEST_APP_ID = "HKE_TEST_APP";
  public static final String DEMO_ORG_ID = "HKE_DEMO_ORG";
  public static final String DEMO_APP_ID = "HKE_DEMO_APP";

  public static final String BANK_DEMO_IP_TEST = "http://192.168.45.93:8084";
  public static final String BANK_DEMO_IP_DEMO = "http://192.168.45.93:8085";
}
