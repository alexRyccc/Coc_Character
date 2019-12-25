package com.coc.character;



import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
//  (exclude = {RedisAutoConfiguration.class, RedisRepositoriesAutoConfiguration.class})
@SpringBootApplication
public class CharacterApplication {

    private static final Class<CharacterApplication> applicationClass = CharacterApplication.class;
    private static Logger logger = LoggerFactory.getLogger(CharacterApplication.class);

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CharacterApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
        logger.info("Application has started");
    }
}
