package com.timnjonjo.robotapocalypse.api;

import com.timnjonjo.robotapocalypse.clients.RobotClient;
import com.timnjonjo.robotapocalypse.models.RobotData;
import com.timnjonjo.robotapocalypse.models.SurvivorData;
import com.timnjonjo.robotapocalypse.models.SurvivorsSummary;
import com.timnjonjo.robotapocalypse.services.SurvivorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@RestController
@RequestMapping("v1/api/reports")
@Slf4j
public class ReportsController {

    private final RobotClient robotClient;
    private final SurvivorService survivorService;

    public ReportsController(RobotClient robotClient, SurvivorService survivorService) {
        this.robotClient = robotClient;
        this.survivorService = survivorService;
    }

    /**
     * • TODO: Percentage of infected survivors.
     * • TODO: Percentage of non-infected survivors.
     * • TODO: List of infected survivors
     * • TODO: List of non-infected survivors
     */
    /* List of robots*/
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("robots")
    public List<RobotData> getRobots() {
        log.info("Get List of Robots Request.");
        return robotClient.getRobots();
    }

    /*List of infected survivors*/
    @GetMapping("survivors")
    public List<SurvivorData> infectedSurvivors(@RequestParam boolean infected){
        return this.survivorService.getSurvivors(infected);
    }

    @GetMapping("survivors-summary")
    public SurvivorsSummary infectedSurvivors(){
        return this.survivorService.getSummary();
    }

}
