package com.self;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class SpringbootReactiveprogrammingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootReactiveprogrammingApplication.class, args);
    }

}
