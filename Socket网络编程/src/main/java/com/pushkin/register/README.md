https://www.acfun.cn/v/ac13837146_3



pom: 
还得配置
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
        </dependency>
否则com.pushkin.register.autoconfig.RegistryAutoConfiguration会报spring Boot configuration annotation processor not configured

注意不要忘记此文件
META-INF/spring.factories
指定自动配置的类
# Auto Configure
org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.pushkin.register.autoconfig.RegistryAutoConfiguration




1. 添加注册中心的依赖
2. 提供者项目配置文件:
server.port=9100
spring.application.name=spring-cloud-service-provider
spring.registry.zookeeper.zkAddress=127.0.0.1:2181
spring.registry.zookeeper.server=true