# Blog
个人博客项目的后端实现

使用技术：
SpringBoot + Mybatis + Mysql + Redis

Mysql主从同步

其中发送短信功能使用第三方平台，位于com.isco.Blog.util包下

src/main/resource/generateConfig.xml用于对应数据库生成对应的Mapper以及POJO，使用前需要对其进行配置，需要对应生成的数据库表
使用方法：
使用Maven-build： 执行 mybatis-generator:generate

数据库设计：图片1.png

#Introduction

Personal blog project back-end implementation

The use of the technical：

SpringBoot & Mybatis & Mysql & Redis

Mysql Master & Slave
