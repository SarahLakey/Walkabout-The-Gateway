package org.launchcode.walkabout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories
//@EntityScan({"org.launchcode.walkabout.models.User", "org.launchcode.walkabout.data.UserRepository"})
public class WalkaboutTheGatewayApplication {
        public static void main(String[] args) {SpringApplication.run(WalkaboutTheGatewayApplication.class, args);
        }
    }
