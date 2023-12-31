package uz.xb.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RobbitMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobbitMqApplication.class, args);
    }

}
