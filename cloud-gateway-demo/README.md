遇到问题：
    启动报错：hiddenHttpMethodFilter could not be registered，same name bean GatewayAutoConfiguration has been registered;
    解决：springcloud Finchley.SR2版本，对应需要springboot 2.0.6.RELEASE版本，而我本来使用的是2.1.4.RELEASE版本
    启动报错:
    ````Parameter 0 of method modifyRequestBodyGatewayFilterFactory in org.springframework.cloud.gateway.config.GatewayAutoConfiguration required a bean of type 'org.springframework.http.codec.ServerCodecConfigurer' that could not be found.````
    解决：由于gateway自带netty，所以与spring-boot-starter-web中的spring-boot-starter-tomcat冲突，在pom中去除该依赖