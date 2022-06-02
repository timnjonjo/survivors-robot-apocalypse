package com.timnjonjo.robotapocalypse;

import com.timnjonjo.robotapocalypse.configs.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({AppConfiguration.class})
public class RobotApocalypseApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobotApocalypseApplication.class, args);
    }

}
