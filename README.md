# falseCloud 
 本项目是使用spring-cloud 为基础，集成了nacos,spring-cloud-gateway,spring-cloud-hystrix,
 spring-cloud-openfeign,spring-cloud-oauth2,spring-cloud-security,mysql,mybatis-plus,redis等技术
    
    
    nacos:服务注册中心和配置中心
    spring-cloud-gateway:网关，限流
    spring-cloud-hystrix:熔断，降级
    spring-cloud-openfeign：服务之间的调用
    spring-cloud-oauth2,spring-cloud-security：权限控制
    mysql：数据库类型
    mybatis-plus：Java持久层框架
    redis:数据缓存
 
 
    false_cloud:父工程
        -admin:主工程
        -common:通用，帮助类工程
        -gateway:网关
        -oauth2：权限认证
        -order：订单工程
        -nacos  阿里巴巴的服务注册中心
        
    nacos 服务注册中心和配置中心
          从nacos官网（https://nacos.io/zh-cn/docs/quick-start.html）可以下载，或者使用git下载（git clone https://github.com/alibaba/nacos.git）
          下载好文件需要将完成以下步骤
                1.将conf/nacos-mysql.sql  文件执行到你的数据库当中
                2.修改 conf/application.properties文件中的数据库连接地址及账号密码
                3.打开bin目录，点击运行startup 文件
                4.服务localhost:8848  默认端口为8848  账号/密码 : nacos/nacos
                完成上面4步服务注册中心就完成了
          nacos和eureka的区别：
                1.在部署上 使用nacos 直接下载jar运行即可 
                  使用eureka 则需要创建eureka的服务注册中心工程和创建eureka 的服务的配置中心两个工程，提高运维的成本
                2.nacos:支持 ap（可用性+分离容忍）  cp（一致性+分离容忍） 两种原则
                  eureka:则支持AP（可用性+分离容忍）原则
                3.nacos是支持中文文档的，更容易上手开发
          nacos的使用：
                1.在服务工程的启动类中添加@EnableDiscoveryClient
                2.在配置文件中添加相关配置
                    spring:
                      cloud:
                        nacos:
                          config:
                            server-addr: 127.0.0.1:8848
                            file-extension: yml
                          discovery:
                            server-addr: 127.0.0.1:8848
                完成这两步，启动admin工程，再访问localhost:8848  在服务列表中能看到已注册的服务
          
        
    gateway 是集成spring-cloud-gateway 作为统一网关中心
        zuul 使用的是阻塞的api 而且不支持任何的长连接 比如 ：WebSockets
        gaterway 使用的是非阻塞api  ，而且支持长连接 支持WebSockets  也支持限流等新特性
        
        配置:
        spring:
          cloud:
            gateway:
              routes:
                 - id: admin-route
                   uri: lb://serviceAdmin
                   predicates:
                     - Path=/api/**
                   filters:
                     - StripPrefix=1
                id：我们自定义的路由 ID，保持唯一
                uri：目标服务地址
                predicates：路由条件，Predicate 接受一个输入参数，返回一个布尔值结果。该接口包含多种默认方法来将 Predicate 组合成其他复杂的逻辑（比如：与，或，非）。
                filters：过滤规则，本示例暂时没用。
    
    
    
    oauth2:  主要实现端，Token 的生成、刷新、验证都在认证中心完成。
        集成oauth2有需要引入jar包
            spring-cloud-starter-oauth2
            spring-cloud-starter-security
        如果将token保存在redis中，则还需要引入
            spring-boot-starter-data-redis
        实现oauth2 要实现AuthorizationServerConfigurerAdapter ResourceServerConfigurerAdapter WebSecurityConfigurerAdapter UserDetailsService
    
            1.创建AuthorizationServerConfig  继承 AuthorizationServerConfigurerAdapter类型
                1.1：添加@EnableAuthorizationServer和 @Configuration注解
                1.2：重写三个configure 方法的。
                    1.2.1：重写参数为：ClientDetailsServiceConfigurer 方法 设置账号 密码 类型 作用域 token的有效时间 刷新token的有效时间：
                        clients.inMemory()
                                //账号
                                .withClient("pro")
                                //授权同意的类型
                                .authorizedGrantTypes("password", "refresh_token")
                                //有效时间
                                .accessTokenValiditySeconds(60 * 60 * 30)
                                //刷新有效时间
                                .refreshTokenValiditySeconds(60 * 60 * 60)
                                .resourceIds("rid")
                                //作用域，范围
                                .scopes("all")
                                //密码
                                .secret(new BCryptPasswordEncoder().encode("123"));
                    1.2.2：重写参数为AuthorizationServerEndpointsConfigurer的方法，将用户验证，token存放到redis中
                        endpoints
                               .tokenStore(new RedisTokenStore(redisConnectionFactory))
                               //身份验证管理
                               .authenticationManager(authenticationManager)
                               .userDetailsService(userDetailsService);
                               
                    1.2.3：重写参数为AuthorizationServerSecurityConfigurer的方法，设置允许客户端表单身份验证
                        security.allowFormAuthenticationForClients();
        
        