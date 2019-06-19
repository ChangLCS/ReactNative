- 使用 vscode 调试需要先启动安卓模拟器或者连接真机

- 生成一个签名密钥命令

```
keytool -genkeypair -v -keystore app-react-native.develop.keystore -alias app-react-native-develop -keyalg RSA -keysize 2048 -validity 50000
```
