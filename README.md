# Android加固

# 目录介绍
1. MySourceApkByAS app源代码
    普通源代码
2. DecodeApkByAS 壳app源代码
    * 自定义Applicaton （ProxyApplication），重写了attachBaseContext -> onCreate
    * attachBaseContext 提取原始apk；onCreate 修改makeApplication
3. Encrypt dex加密函数
    * 将源apk 复制到壳dex内容后面，修改dex file size;SHA1;CheckSum 等文件头