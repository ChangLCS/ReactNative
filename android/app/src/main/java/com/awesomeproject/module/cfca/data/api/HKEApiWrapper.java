/*
 * Copyright (c) CFCA 2016.
 */

package com.awesomeproject.module.cfca.data.api;

//import cn.com.cfca.hke_sdk.util.Logger;

import cn.com.cfca.sdk.hke.Callback;
import cn.com.cfca.sdk.hke.HKEException;
import cn.com.cfca.sdk.hke.HKEWithPasswordApi;
import cn.com.cfca.sdk.hke.data.AuthenticateInfo;
import cn.com.cfca.sdk.hke.data.CFCACertificate;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

import java.security.Signature;

/**
 * Created by wufan on 16/3/29.
 * 与云证通服务器交互类 使用RxJava 进行事件监听响应
 * <p>
 * 注：由于HKEApi回调均为主线程, HKEApiWrapper的监听处理均会在主线程中,
 * 如果回调中需要发起网络请求，请加上subscribeOn(Schedulers.io())
 * 如：
 * hkeApiWrapper.requestHKEServerRandom()
 * .flatMap(serverRandom -> {
 * // 如果没有subscribeOn，则会在主线程中发起网络请求，引起异常
 * return demoApi.auth().subscribeOn(Schedulers.io());
 * })
 */
public class HKEApiWrapper {
    private static final Object SUCCESS = new Object();
    private static HKEApiWrapper instance;
    private final HKEWithPasswordApi hkeApi;

    private HKEApiWrapper(HKEWithPasswordApi api) {
        this.hkeApi = api;
    }

    public boolean isSupportSE() {
        return hkeApi.isSupportSE();
    }

    public static void intialize(HKEWithPasswordApi hkeWithPasswordApi) {
        instance = new HKEApiWrapper(hkeWithPasswordApi);
    }

    public static HKEApiWrapper getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Should call initialize before getInstance");
        }

        return instance;
    }

    /**
     * 获取服务器端随机数
     *
     * @param name               用户名
     * @param identityType       证件类型
     * @param identityCardNumber 证件号
     * @param phoneNumber        手机号
     * @param deviceID           设备ID
     * @return 服务器端随机数
     */
    public Flowable<String> requestHKEServerRandom(final String name, final String identityType,
                                                   final String identityCardNumber, final String phoneNumber, final String deviceID) {
//    Logger.i(HKEApiWrapper.class.getSimpleName(), "requestRandom------");
        return Flowable.create(
                emitter -> hkeApi.requestHKEServerRandom(name, identityType, identityCardNumber,
                        phoneNumber, deviceID, new Callback<String>() {
                            @Override
                            public void onResult(String s) {
                                emitter.onNext(s);
                                emitter.onComplete();
                            }

                            @Override
                            public void onError(HKEException e) {
                                emitter.onError(e);
                            }
                        }), BackpressureStrategy.BUFFER);
    }

    /**
     * 获取IFAA版本服务器端随机数
     *
     * @param name               用户名
     * @param identityType       证件类型
     * @param identityCardNumber 证件号
     * @param phoneNumber        手机号
     * @param deviceID           设备ID
     * @param userInfo           用户信息
     * @return 服务器端随机数
     */
    public Flowable<String> requestHKEServerRandom(final String name, final String identityType,
                                                   final String identityCardNumber, final String phoneNumber, final String deviceID,
                                                   String userInfo) {
//    Logger.i(HKEApiWrapper.class.getSimpleName(), "requestRandom------");
        return Flowable.create(
                emitter -> hkeApi.requestHKEServerRandom(name, identityType, identityCardNumber,
                        phoneNumber, deviceID, userInfo, new Callback<String>() {
                            @Override
                            public void onResult(String s) {
                                emitter.onNext(s);
                                emitter.onComplete();
                            }

                            @Override
                            public void onError(HKEException e) {
                                emitter.onError(e);
                            }
                        }), BackpressureStrategy.BUFFER);
    }

    /**
     * 花旗银行获取服务器端随机数
     *
     * @param name               用户名
     * @param identityType       证件类型
     * @param identityCardNumber 证件号
     * @param phoneNumber        手机号
     * @param deviceID           设备ID
     * @return 服务器端随机数
     */
    public Flowable<String> requestHKEServerRandomWithEncryptedData(final String name,
                                                                    final String identityType, final String identityCardNumber, final String phoneNumber,
                                                                    final String deviceID, final String encryptedKey, final String subscriberIdentity) {
        return Flowable.create(
                emitter -> hkeApi.requestHKEServerRandomWithEncryptedData(name, identityType,
                        identityCardNumber, phoneNumber, deviceID, encryptedKey, subscriberIdentity,
                        new Callback<String>() {
                            @Override
                            public void onResult(String s) {
                                emitter.onNext(s);
                                emitter.onComplete();
                            }

                            @Override
                            public void onError(HKEException e) {
                                emitter.onError(e);
                            }
                        }), BackpressureStrategy.BUFFER);
    }

    /**
     * 花旗银行IFAA版本获取服务器端随机数
     *
     * @param name               用户名
     * @param identityType       证件类型
     * @param identityCardNumber 证件号
     * @param phoneNumber        手机号
     * @param deviceID           设备ID
     * @param userInfo           用户信息
     * @return 服务器端随机数
     */
    public Flowable<String> requestHKEServerRandomWithEncryptedData(final String name,
                                                                    final String identityType, final String identityCardNumber, final String phoneNumber,
                                                                    final String deviceID, final String encryptedKey, final String subscriberIdentity,
                                                                    String userInfo) {
        return Flowable.create(
                emitter -> hkeApi.requestHKEServerRandomWithEncryptedData(name, identityType,
                        identityCardNumber, phoneNumber, deviceID, encryptedKey, subscriberIdentity, userInfo,
                        new Callback<String>() {
                            @Override
                            public void onResult(String s) {
                                emitter.onNext(s);
                                emitter.onComplete();
                            }

                            @Override
                            public void onError(HKEException e) {
                                emitter.onError(e);
                            }
                        }), BackpressureStrategy.BUFFER);
    }

    /**
     * 身份认证
     *
     * @param serverRandomSignature 使用机构证书对身份认证返回的随机数做的签名（用以鉴别客户端身份）
     */
    public Flowable<AuthenticateInfo> authenticate(final String serverRandomSignature) {
        return Flowable.create(emitter -> hkeApi.authenticateWithServerSignature(serverRandomSignature,
                new Callback<AuthenticateInfo>() {
                    @Override
                    public void onResult(AuthenticateInfo s) {
                        if (s.getCertificates().size() > 0) {
//              Logger.e("SN", s.getCertificates().get(0).getSerialNumber());
                        }
                        if (s.getPinState() == 3) {
                            emitter.onError(new HKEException(-1, "Pin is locked!"));
                        } else if (s.getPinState() == 4) {
                            emitter.onError(new HKEException(-1, "Pin is locked forever"));
                        } else {
                            emitter.onNext(s);
                            emitter.onComplete();
                        }
                    }

                    @Override
                    public void onError(HKEException e) {
                        emitter.onError(e);
                    }
                }), BackpressureStrategy.BUFFER);
    }

    /**
     * 下载证书
     *
     * @return 证书对象
     */
    public Flowable<CFCACertificate> downloadCertificate(String extension) {
        return Flowable.create(
                emitter -> hkeApi.downloadCertificate(extension, new Callback<CFCACertificate>() {
                    @Override
                    public void onResult(CFCACertificate certificate) {
                        emitter.onNext(certificate);
                        emitter.onComplete();
                    }

                    @Override
                    public void onError(HKEException e) {
                        emitter.onError(e);
                    }
                }), BackpressureStrategy.BUFFER);
    }

    /**
     * 签名
     *
     * @param businessText          待签名交易报文
     * @param businessTextSignature 带签名交易报文签名
     * @param encryptedPassword     安全控件加密后的密文
     * @param encryptedCilentRandom 安全控件用于加密的客户端随机数
     */
    public Flowable<String> sign(final String businessText, final String businessTextSignature,
                                 final String encryptedPassword, final String encryptedCilentRandom) {
        return Flowable.create(
                emitter -> hkeApi.signMessageWithBusinessMessage(businessText, businessTextSignature,
                        encryptedPassword, encryptedCilentRandom, new Callback<String>() {
                            @Override
                            public void onResult(String signature) {
                                emitter.onNext(signature);
                                emitter.onComplete();
                            }

                            @Override
                            public void onError(HKEException e) {
                                emitter.onError(e);
                            }
                        }), BackpressureStrategy.BUFFER);
    }

    /**
     * 设置PIN码
     *
     * @param encryptedPassword     安全控件加密后的密文
     * @param encryptedClientRandom 安全控件用于加密的客户端随机数
     */
    public Flowable<Object> setPassword(final String encryptedPassword,
                                        final String encryptedClientRandom) {
        return Flowable.create(emitter -> hkeApi.setPassword(encryptedPassword, encryptedClientRandom,
                new Callback<Void>() {
                    @Override
                    public void onResult(Void aVoid) {
                        emitter.onNext(SUCCESS);
                        emitter.onComplete();
                    }

                    @Override
                    public void onError(HKEException e) {
                        emitter.onError(e);
                    }
                }), BackpressureStrategy.BUFFER);
    }

    /**
     * 修改密码
     *
     * @param originalEncryptedPassword     旧密码密文
     * @param originalEncryptedCilentRandom 旧密码客户端随机数
     * @param newEncryptedPassword          新密码密文
     * @param newEncryptedCilentRandom      新密码客户端随机数
     */
    public Flowable<Object> changePassword(final String originalEncryptedPassword,
                                           final String originalEncryptedCilentRandom, final String newEncryptedPassword,
                                           final String newEncryptedCilentRandom) {
        return Flowable.create(
                emitter -> hkeApi.changePassword(originalEncryptedPassword, originalEncryptedCilentRandom,
                        newEncryptedPassword, newEncryptedCilentRandom, new Callback<Void>() {
                            @Override
                            public void onResult(Void aVoid) {
                                emitter.onNext(SUCCESS);
                                emitter.onComplete();
                            }

                            @Override
                            public void onError(HKEException e) {
                                emitter.onError(e);
                            }
                        }), BackpressureStrategy.BUFFER);
    }

    /**
     * 验证密码
     *
     * @param encryptedPassword     密码密文
     * @param encryptedClientRandom 客户端随机数
     */
    public Flowable<Object> verifyPassword(final String encryptedPassword,
                                           final String encryptedClientRandom) {
        return Flowable.create(
                emitter -> hkeApi.verifyPassword(encryptedPassword, encryptedClientRandom,
                        new Callback<Void>() {
                            @Override
                            public void onResult(Void aVoid) {
                                emitter.onNext(SUCCESS);
                                emitter.onComplete();
                            }

                            @Override
                            public void onError(HKEException e) {
                                emitter.onError(e);
                            }
                        }), BackpressureStrategy.BUFFER);
    }

    public Signature generateFingerprintSignatureObject(boolean isActivateFingerprint)
            throws HKEException {
        return hkeApi.generateFingerprintSignatureObject(isActivateFingerprint);
    }

    public Flowable<Object> activateFingerprint(final Signature signature) {
        return Flowable.create(emitter -> hkeApi.activateFingerprint(signature, new Callback<Void>() {
            @Override
            public void onResult(Void aVoid) {
                emitter.onNext(SUCCESS);
                emitter.onComplete();
            }

            @Override
            public void onError(HKEException e) {
                emitter.onError(e);
            }
        }), BackpressureStrategy.BUFFER);
    }

    public Flowable<Object> deactivateFingerprint() {
        return Flowable.create(emitter -> hkeApi.deactivateFingerprint(new Callback<Void>() {
            @Override
            public void onResult(Void aVoid) {
                emitter.onNext(SUCCESS);
                emitter.onComplete();
            }

            @Override
            public void onError(HKEException e) {
                emitter.onError(e);
            }
        }), BackpressureStrategy.BUFFER);
    }

    public Flowable<String> signByFingerprint(final String businessText,
                                              final String businessTextSignature, final Signature signature) {
        return Flowable.create(
                emitter -> hkeApi.signBusinessMessageByFingerprint(businessText, businessTextSignature,
                        signature, new Callback<String>() {
                            @Override
                            public void onResult(String result) {
                                emitter.onNext(result);
                                emitter.onComplete();
                            }

                            @Override
                            public void onError(HKEException e) {
                                emitter.onError(e);
                            }
                        }), BackpressureStrategy.BUFFER);
    }

    public Flowable<byte[]> envelopeEncrypt(final String plainData) {
        return Flowable.create(
                emitter -> hkeApi.encryptSM2Envelope(plainData.getBytes(), new Callback<byte[]>() {
                    @Override
                    public void onResult(byte[] s) {
                        emitter.onNext(s);
                        emitter.onComplete();
                    }

                    @Override
                    public void onError(HKEException e) {
                        emitter.onError(e);
                    }
                }), BackpressureStrategy.BUFFER);
    }

    public Flowable<String> envelopeDecrypt(final byte[] encryptData, final String businessMessage,
                                            final String businessSign, final String password, final String clientRandom) {
        return Flowable.create(
                emitter -> hkeApi.decryptSM2EnvelopeByPassword(encryptData, businessMessage, businessSign,
                        password, clientRandom, new Callback<byte[]>() {
                            @Override
                            public void onResult(byte[] s) {
                                emitter.onNext(new String(s));
                                emitter.onComplete();
                            }

                            @Override
                            public void onError(HKEException e) {
                                emitter.onError(e);
                            }
                        }), BackpressureStrategy.BUFFER);
    }

    public Flowable<String> envelopeDecryptByFinger(final byte[] encryptData,
                                                    final String businessMessage, final String businessSign, final Signature signature) {
        return Flowable.create(
                emitter -> hkeApi.decryptSM2EnvelopeByFingerPrint(encryptData, businessMessage,
                        businessSign, signature, new Callback<byte[]>() {
                            @Override
                            public void onResult(byte[] s) {
                                emitter.onNext(new String(s));
                                emitter.onComplete();
                            }

                            @Override
                            public void onError(HKEException e) {
                                emitter.onError(e);
                            }
                        }), BackpressureStrategy.BUFFER);
    }
}
