# seata_nacoe_springcloud

1、 官网的例子，在一些版本中无法使用。
2、docs的文件夹里有详细的说明


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
- 打开浏览器，地址栏输入：http://http://localhost:3000