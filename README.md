# fast-platform

#### 介绍

![](https://imgkr2.cn-bj.ufileos.com/8a312123-9219-46fb-96ed-39a961875755.png?UCloudPublicKey=TOKEN_8d8b72be-579a-4e83-bfd0-5f6ce1546f13&Signature=F%2FDacd6jCoyTjv1yw6SLcDVk0qw%3D&Expires=1596265574)

#### 软件架构

1. Gradle 6.5.x
2. SpringBoot 2.3.x
3. Mysql 8.0.x
4. ORM SpringDataJpa

#### 安装教程

##### 本地gradle配置

需要在`$USERHOME/.gradle`文件夹下创建一个`init.gradle`文件，文件中定义了中央仓库使用阿里镜像源，以及私人仓库地址
```gradle
allprojects {

    ext {
        // 如果不进行jar包推送到中央仓库操作，username、password不为空即可
        set('releaseUrl', 'https://repo.rdc.aliyun.com/repository/37313-release-LcooP1/')
        set('snapshotUrl', 'https://repo.rdc.aliyun.com/repository/37313-snapshot-PsuKsX/')
        set('username', "用户名")
        set('password', '密码')
    }    

    repositories {
        maven {
            url 'https://maven.aliyun.com/repository/public'
        }

        maven {
            credentials {
                username "${username}"
                password "${password}"
            }
            url "${releaseUrl}"
        }
        maven {
            credentials {
                username "${username}"
                password "${password}"
            }
            url "${snapshotUrl}"
        }
    }
}

```

#### 使用说明

构建打包命令：
```shell script
# 打包jar文件目标位置./build/libs/..
./gradlew clean bootJar

# =============== linux服务器启动 =============
# 杀掉进程
ps -ef | grep user-web.jar | grep -v grep | awk '{print $2}' | xargs kill -15
# 后台启动
nohup java -jar -Dserver.port=12000 .\user-web\build\libs\user-web.jar > /dev/null &

# ================ docker启动 ================
# 启动
docker-compose up -d
# 停止并删除容器
docker-compose down
# 删除文件中未定义的容器
docker-compose down --remove-orphans

```

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 码云特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5.  码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
