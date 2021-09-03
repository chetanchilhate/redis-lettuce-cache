package com.cj.redislettucecache.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@EnableCaching
@Configuration
@Slf4j
public class RedisConfiguration {

    @Value("${cache.redis.hostname}")
    private String cacheHostname;

    @Value("${cache.redis.port}")
    private String cachePort;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {

        log.info("Cache Hostname : " + cacheHostname);
        log.info("Cache Port : " + cachePort);

        return new LettuceConnectionFactory(new RedisStandaloneConfiguration(cacheHostname, Integer.parseInt(cachePort)));
    }

    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        final RedisSerializationContext.SerializationPair<?> serializationPair =  RedisSerializationContext
                .SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());

        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(1))
                .disableCachingNullValues()
                .serializeValuesWith(serializationPair);
    }

}
