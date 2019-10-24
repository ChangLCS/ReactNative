- 使用 vscode 调试需要先启动安卓模拟器或者连接真机

- 生成一个签名密钥命令

```
keytool -genkeypair -v -keystore app-react-native.develop.keystore -alias app-react-native-develop -keyalg RSA -keysize 2048 -validity 50000
```

- android 本地启动
```
react-native run-android
```

# Android Studio调试React Native项目

- ### 在 android/app/src/main 目录下创建一个 assets空文件夹
```
mkdir android/app/src/main/assets
```

- ### 在项目根目录运行
```
react-native bundle --platform android --dev false --entry-file index.js --bundle-output android/app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res/
```

- ### tips

注意了，是编译index.js而不是index.android.js，因为react-native新版本已经没有index.android.js和index.ios.js两个文件了，只有一个index.js文件,所以要编译index.js 
会发现 assets文件夹下多出两个文件