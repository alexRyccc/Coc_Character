package com.coc.character;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
//  (exclude = {RedisAutoConfiguration.class, RedisRepositoriesAutoConfiguration.class})
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class CharacterApplication {

    private static final Class<CharacterApplication> applicationClass = CharacterApplication.class;
    private static Logger logger = LoggerFactory.getLogger(CharacterApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
        logger.info("Application has started");
    }


}
