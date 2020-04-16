


## 1. 简介

 Master-Worker模式是常用的并行设计模式
 
 核心思想:系统有两种进程协议工作
- Master进程: 负责接收与分配任务
- Worker进程: 负责处理子任务

当Worker进程将子任务处理完后,将结果返回给Master进程,由Master进程归纳和汇总, 从而得到系统结果

![master1](./img/master1.png)

## 2. 优点
 - 任务分解, 并行化, 提升性能
 - 异步
 
 