## Netty聊天demo

### 功能

- 登陆

- 退出登陆

- 单聊

- 群聊

### IDEA启动方式

- 服务端启动

![server.jpg](https://i.loli.net/2020/03/11/GXompFWPwi2OL7Y.png)

- 客户端启动

![client.jpg](https://i.loli.net/2020/03/11/S7k3xHbuhoGwsrn.png)

- 多个客户端

![mult-client.jpg](https://i.loli.net/2020/03/11/9I7ixpb58K4kOJE.png)

### Jar包启动方式

- mvn clean package

- 服务端
  - java -cp target/netty-im-jar-with-dependencies.jar com/shenjies88/practice/NettyServer

- 客户端
   - java -cp target/netty-im-jar-with-dependencies.jar com/shenjies88/practice/NettyClient


### 操作指令

- sendToUser 发送消息给指定用户

- logout 退出登陆

- createGroup 创建群聊

- joinGroup 加入群聊

- listGroupMembers 群聊成员列表
