# 异步编程之CompletableFuture

在我们的开发过程中,经常遇到一些复杂的逻辑,需要分解成多个任务job去处理,常规的
one-by-one这种串行编码的方式虽然简单, 但性能方面不尽人意, 一般的优化可以
利用提升系统资源使用率, 使用多线程的方式去实现一些job的并行化, 但job之间很多时候
是相互依赖耦合,job之间需要进行数据的交互, 那这种场景又如何实现呢? 
答案是: 异步编程

>串行任务(同步)实现并行化(异步化)本质还是用多线程+回调实现。


JDK1.5提供了Future和Callable的实现,去实现这种需求场景
 