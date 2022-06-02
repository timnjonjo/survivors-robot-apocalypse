package com.timnjonjo.robotapocalypse.clients;

import com.timnjonjo.robotapocalypse.configs.AppConfiguration;
import com.timnjonjo.robotapocalypse.exceptions.NoRobotsFoundException;
import com.timnjonjo.robotapocalypse.models.RobotData;
import com.timnjonjo.robotapocalypse.utils.Helper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@Component
@Slf4j
public class RobotClient {
    private final RestTemplate restTemplate;
    private final AppConfiguration configuration;

    public RobotClient(AppConfiguration configuration) {
        this.restTemplate = new RestTemplate();
        this.configuration = configuration;
    }

    public List<RobotData> getRobots() {
        log.info("Getting Robots From Robot CPU");
        final String url = UriComponentsBuilder
                .fromUriString(configuration.getUrl())
                .build().toString();
        ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            log.error("No Robots Found from the Robots CPU. HttpStatus: {}", response.getStatusCode());
            throw new NoRobotsFoundException();
        }
        return Helper.readObjectList(response.getBody(), RobotData.class);
    }
}
