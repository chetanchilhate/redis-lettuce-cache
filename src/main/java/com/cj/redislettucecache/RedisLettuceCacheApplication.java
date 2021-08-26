package com.cj.redislettucecache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class RedisLettuceCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisLettuceCacheApplication.class, args);
	}

}
