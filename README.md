# RPC
RPC（Remote Procedure Call）远程过程调用。本例为简易版rpc框架，实现功能与dubbo类似。

## 源码
https://github.com/kangyonggan/rpc.git

## 架构
![](https://ws2.sinaimg.cn/large/006tNc79ly1g04tkewr36j30im078aa2.jpg)

1. Providor服务端启动，将服务注册到Register注册中心
2. Consumer客户端启动，将引用注册到Register注册中心，并订阅引用服务变化和降级服务变化
3. Register注册中心有服务注册或者下线，或者降级服务的新增或者删除，都会通知Consumer客户端，客户端内部负载均衡路由调用
4. Consumer客户端根据从Register注册中心获取的服务列表，根据负载均衡算法路由调用指定Providor服务端
5. Consumer客户端配置监控，将服务调用详情数据推送给Manage治理中心
6. Manage治理中心管理降级服务，接收监控数据，查看监控数据和图表
7. Gateway泛化网关配置http请求转rpc服务调用关系，将http请求转成rpc调用，返回json结果

## 环境
1. jdk1.8
2. maven3
3. IDEA
4. git

## 功能列表
- 注册中心
- xml配置
- 分布式通讯
- 定向服务
- 定向服务
- 负载均衡策略
- 集群容错策略
- 服务版本控制
- 设置超时时间
- 结果缓存
- 泛化调用
- 上下文信息
- 隐式参数
- 异步调用
- 本地调用
- 拦截器
- 服务降级
- 优雅停机
- telnet治理
- 监控
- 治理中心
- 泛化网关
- schema配置手册
- And So On


> 参考资料：[http://www.recorddrip.com/dokuwiki/doku.php?id=%E5%88%86%E4%BA%AB:%E6%8A%80%E6%9C%AF:gxxrpc:gxxrpc%E4%BB%8B%E7%BB%8D%E6%96%87%E6%A1%A3](http://www.recorddrip.com/dokuwiki/doku.php?id=%E5%88%86%E4%BA%AB:%E6%8A%80%E6%9C%AF:gxxrpc:gxxrpc%E4%BB%8B%E7%BB%8D%E6%96%87%E6%A1%A3)

特别鸣谢：关向辉