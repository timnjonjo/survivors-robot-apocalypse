package com.timnjonjo.robotapocalypse.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@ConfigurationProperties(prefix = "robot.cpu")
public class AppConfiguration {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
