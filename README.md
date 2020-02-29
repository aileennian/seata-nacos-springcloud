# seata_nacoe_springcloud

- seata官网的例子很多，但没有说明，而且和springcloud版本整合中有一些问题；

- 该例子本人花费了1周多暗无天日的时间，整出来的。文档不全，硬是一个一个的的调试完成

- 关于部署使用，docs的文件夹里有详细的说明

- 稍后附上一份价值不菲的关于分布式事务的整体PPT教程

- 这里：nacos充当注册中心与配置中心，seata分布式事务，springcloud与springboot都是最新版本

# seata server
- 版本：nacos-server-1.1.4
- 官网：seata.io

# nacos server
- 版本：seata-server-1.0.0
- 官网：nacos.io

# 核心包版本
- Springboot：2.2.2.RELEASE
- SpringCloud: Hoxton.SR1(2.2.1.RELEASE) -——nacos需要
- Nacos-client：1.1.4
- spring-cloud-alibaba-nacos: 2.2.0.RELEASE
- seata-all: 1.0.0
- httpclient.version: 4.5.2
- mysql：慎用V8版本
- druiddruid:1.1.21

# 详细文档，见docs目录
支持工具, 如果npm工具没有，则可以安装node.js会自动拥有npm
- 配置
```
npm i docsify docsify--cli -g --registry=https://registry.npm.taobao.org
docsify serve docs
docsify start docs
```
- 打开浏览器，地址栏输入：http://localhost:3000
