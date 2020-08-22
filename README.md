# fast-platform

#### 介绍

![](https://imgkr2.cn-bj.ufileos.com/8a312123-9219-46fb-96ed-39a961875755.png?UCloudPublicKey=TOKEN_8d8b72be-579a-4e83-bfd0-5f6ce1546f13&Signature=F%2FDacd6jCoyTjv1yw6SLcDVk0qw%3D&Expires=1596265574)

#### 软件架构

1. Maven 3.6.x
2. SpringBoot 2.3.x
3. Mysql 8.0.x
4. ORM Mybatis-Plus 3.3.x
5. 网关 [Spring-cloud-gateway](https://docs.spring.io/spring-cloud-gateway/docs/2.2.4.RELEASE/reference/html/#gateway-starter)
6. 注册中心 [Nacos 1.3.2](https://nacos.io/zh-cn/docs/what-is-nacos.html)
7. 微服务调用 [OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/2.2.4.RELEASE/reference/html/)

#### 安装教程


#### 使用说明

构建打包命令：
```shell script

# =============== linux服务器启动 =============
# 打包指定子模块，并处理相关依赖
mvn clean package -pl user-web -am
# 杀掉进程
ps -ef | grep user-web.jar | grep -v grep | awk '{print $2}' | xargs kill -15
# 后台启动
nohup java -jar -Dserver.port=12000 .\user-web\build\libs\user-web.jar > /dev/null &

# ================ docker启动 ================

# 重新构建镜像
docker-compose build
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

