# project
初学spring cloud 框架，许多知识点在这里记录下

1>feign调用服务丢失session，feign无法将cookie返回个客户端，HttpServletRespose respose添加请求的内容不能通过feign返回给客户端

  ：丢失session参考博文https://blog.csdn.net/crystalqy/article/details/79083857 ，注意启动类中注入该配置文件，
  
  ：respose无法通过feign返回给客户端cookie，导致登录认证无法实现，这里可以直接将登录模块从业务逻辑模块抽出，直接nginx方向代理登录模块，不通过feign。这是我的nginx配置 https://github.com/endwith/project/blob/master/nginx%E9%85%8D%E7%BD%AE.txt
  
2>feign入参

  ：feign入参参数必须添加注解@RequestParam(value = "pageNum", defaultValue =false) 没有注解会自动添加@RequestBody();如果过多@RequestBody()或报错，建议都用@RequestParam。不要入参实体类。
  
3>feign上传文件：produces，consumes必须要，入参注解改为@RequestPart
  /**
     *上传图片
     */
    @RequestMapping(value ="/a/u/picture",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    JSONObject loadPicture(@RequestPart(value = "picture",required = false)MultipartFile picture);
    @Configuration
     class MultipartSupportConfig {

        @Bean
        @Primary
        @Scope("prototype")
        public SpringFormEncoder multipartFormEncoder() {
            return new SpringFormEncoder();
        }

        @Bean
        public feign.Logger.Level multipartLoggerLevel() {
            return feign.Logger.Level.FULL;
        }
    }
}

4>zull上传文件：在application.yml文件添加如下
zuul:

  routes:
  
    uploadfile:
    
      path: /admin/**
      
      serviceId: server-feign-admin
      
      
在实际负载的服务server的application.yml添加如下

spring.http.multipart.enabled= true

spring.http.multipart.max-file-size=10Mb

spring.http.multipart.max-request-size=10Mb


文件较大，上传时间长，在zuul配置文件添加 

 ribbon:
 
 ReadTimeout: 120000
 
 ConnectTimeout: 30000
 
feign:

  hystrix:
  
    enabled: true
    
hystrix:

  command:
  
    default:
    
      execution:
      
        isolation:
      
          thread:
          
            timeoutInMilliseconds: 60000
            
            
 5>请求时间长，熔断器触发，实际服务器没有问题
 
 在zuul和feign配置文件application.yml添加如下
 
  ribbon:
  
 ReadTimeout: 120000
 
 ConnectTimeout: 30000
 
feign:

  hystrix:
  
    enabled: true
    
hystrix:

  command:
  
    default:
    
      execution:
      
        isolation:
        
          thread:
          
            timeoutInMilliseconds: 60000
            
            
6>服务server断开，eureka剔除该服务

eureka:

  server:
  
        enableSelfPreservation: false
        
        evictionIntervalTimerInMs: 10000
               
    
7>服务server向eureka发起心跳

#租期更新时间间隔（默认30秒）

eureka.instance.lease-renewal-interval-in-seconds = 10

#租期到期时间（默认90秒）

eureka.instance.lease-expiration-duration-in-seconds = 30
            

8>部署服务器ip地址不是真实ip地址，无法从git上面fetch配置文件
  
  我的解决办法https://blog.csdn.net/as4566/article/details/81292333
