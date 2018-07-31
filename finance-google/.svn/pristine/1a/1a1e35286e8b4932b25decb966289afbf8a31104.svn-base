package com.ptteng.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
     //keyGenerator方法名于KeyGenerator一致不会出bug
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public  Object generate(Object target, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }
//    @Bean
//    public CacheManager cacheManager(
//            @SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
//        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
////        cacheManager.setDefaultExpiration(60);//设置缓存保留时间（seconds）
//        return cacheManager;
//    }
//
//    //1.项目启动时此方法先被注册成bean被spring管理
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(
//            RedisConnectionFactory factory) {StringRedisTemplate template = new StringRedisTemplate(factory);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        return template;
//    }
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(JedisConnectionFactory connectionFactory){

        RedisTemplate<Object, Object> template=new RedisTemplate<Object, Object>();

        template.setConnectionFactory(connectionFactory);
        //实现序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        //实现序列化和反序列化redis的value值,默认使用JdkSerializationRedisSerializer
        //template.setValueSerializer(new RedisObjectSerializer());
        //template.setValueSerializer();
        return template;

    }

    @Bean
    public CacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        // cacheManager.setCacheNames(Arrays.asList("users", "emptyUsers"));
        cacheManager.setUsePrefix(true);
        // Number of seconds before expiration. Defaults to unlimited (0)
        cacheManager.setDefaultExpiration(1800L);
        return cacheManager;
    }
}
