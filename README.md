# Android加固

# 目录介绍
1. MySourceApkByAS app源代码
    * 普通源代码
2. DecodeApkByAS 壳app源代码
    * 自定义Applicaton （ProxyApplication），重写了attachBaseContext -> onCreate
    * attachBaseContext 提取原始apk；onCreate 修改makeApplication
3. Encrypt dex加密函数
    * 将源apk 复制到壳dex内容后面，修改dex file size;SHA1;CheckSum 等文件头

# 运行过程
1. 编译MySourceApkByAS，DecodeApkByAS
    * 注意：DecodeApkByAS的MainActivity是源apk中的MainActivity
2. 提取MySourceApkByAS.apk 与 DecodeApkByAS.dex 放入Encrypt项目下encrypt文件，并运行
    * DecodeApkByAS.dex从DecodeApkByAS.apk中提取
        > unzip DecodeApkByAS.apk -d xxx
3. 运行Encrypt项目生成classes.dex,替换DecodeApkByAS.apk（即 xxx） 文件中classes.dex；并重写打包生成apk
    * 重写打包生成apk
        > cd xxx
        > zip -r DecodeApkByAS.apk .
4. 重写签名apk文件
    * 签名命令
        > arsigner -verbose -keystore keystoreXXX -storepass 123456 -keypass 123456 -sigfile CERT -digestalg SHA1 -sigalg MD5withRSA -signedjar reforceapk_des.apk DecodeApkByAS.apk key1
        > keystoreXXX 代码你自己的签名信息；storepass，keypass为密码；DecodeApkByAS.apk 源apk信息；reforceapk_des.apk 签名后的apk信息；key1 （看Android Studio签名apk）