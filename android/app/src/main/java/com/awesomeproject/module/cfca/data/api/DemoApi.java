/*
 * Copyright (c) CFCA 2016.
 */

package com.awesomeproject.module.cfca.data.api;

import com.awesomeproject.module.cfca.data.request.DeviceInfoRequest;
import com.awesomeproject.module.cfca.data.response.CitiEnctyptedData;
import com.awesomeproject.module.cfca.data.response.DeviceApiResult;
import com.awesomeproject.module.cfca.data.response.DeviceQueryResult;
import com.awesomeproject.module.cfca.data.response.OpenAccountResult;
import com.awesomeproject.module.cfca.data.response.OrderResult;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by wufan on 16/3/25.
 * 与BankDemo进行交互请求类，使用 retrofit 进行网络请求
 */
public interface DemoApi {

  @FormUrlEncoded
  @POST
  Flowable<String> sign(@Url String url, @Field("originText") String originText);

  @FormUrlEncoded
  @POST
  Flowable<String> sign2(@Url String url, @Field("random") String originText);

  @FormUrlEncoded
  @POST
  Flowable<OrderResult> order(@Url String url, @Field("fromAccount") String fromAccount,
                              @Field("payeeName") String payeeName, @Field("receivingBank") String receivingBank,
                              @Field("payeeAccount") String payeeAccount, @Field("amount") String amount,
                              @Field("remark") String remark, @Field("hashAlg") String hashAlg,
                              @Field("signAlg") String signAlg, @Field("payeePhoneNo") String payeePhoneNo,
                              @Field("usePIN") boolean usePIN, @Field("useFingerprint") boolean useFingerprint);
  @GET
  Flowable<String> getUserAutherInfoSign(@Url String url,
                                         @Field("random") String random,
                                         @Field("identityType") String identityType,
                                         @Field("idNo") String idNo,
                                         @Field("phoneNumber") String phoneNumber);

  @FormUrlEncoded
  @POST
  Flowable<OrderResult> orderHuiShang(@Url String url, @Field("anxinSignText") String plain);

  @POST
  Flowable<DeviceApiResult> registerDevice(@Url String url, @Body DeviceInfoRequest deviceInfo);

  @FormUrlEncoded
  @POST
  Flowable<DeviceQueryResult> queryDevice(@Url String url, @Field("deviceTag") String deviceTag);

  @FormUrlEncoded
  @POST
  Flowable<DeviceApiResult> revokeDevice(@Url String url, @Field("deviceTag") String deviceTag);

  @FormUrlEncoded
  @POST
  Flowable<OpenAccountResult> openAccount(@Url String url,
                                          @Field("serialNumber") String serialNumber, @Field("name") String name,
                                          @Field("idType") String idType, @Field("idNo") String idNo,
                                          @Field("phoneNo") String phoneNumber);

  @FormUrlEncoded
  @POST
  Flowable<String> auth(@Url String url, @Field("idType") String idType,
                        @Field("idNum") String idNum, @Field("phoneNo") String phoneNo, @Field("name") String name);

  @FormUrlEncoded
  @POST
  Flowable<CitiEnctyptedData> auth(@Url String url, @Field("idType") String idType,
                                   @Field("idNum") String idNum, @Field("phoneNo") String phoneNo, @Field("name") String name,
                                   @Field("deviceInfoProvidedByOrg") String deviceInfoProvidedByOrg,
                                   @Field("isEncrypted") boolean isEncrypted);

  @FormUrlEncoded
  @POST
  Flowable<OrderResult> decrypt(@Url String url, @Field("remark") String remark,
                                @Field("usePIN") boolean usePIN, @Field("useFingerprint") boolean useFingerprint);
}
