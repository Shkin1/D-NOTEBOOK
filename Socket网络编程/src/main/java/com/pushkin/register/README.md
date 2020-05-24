https://www.acfun.cn/v/ac13837146_3


注意不要忘记此文件
META-INF/spring.factories
指定自动配置的类
# Auto Configure
org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.pushkin.register.autoconfig.RegistryAutoConfiguration



提供者项目配置文件:
server.port=9100
spring.application.name=spring-cloud-service-provider
spring.registry.zookeeper.address=127.0.0.1:2181
spring.registry.zookeeper.server=true