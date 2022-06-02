package com.timnjonjo.robotapocalypse.api;

import com.timnjonjo.robotapocalypse.models.FlagSurvivorRequest;
import com.timnjonjo.robotapocalypse.models.SurvivorData;
import com.timnjonjo.robotapocalypse.models.UpdateLocationRequest;
import com.timnjonjo.robotapocalypse.services.SurvivorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@RestController
@RequestMapping("v1/api/survivor")
@Slf4j
public class SurvivorController {

    private final SurvivorService survivorService;

    public SurvivorController(SurvivorService survivorService) {
        this.survivorService = survivorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSurvivor(@RequestBody @Valid SurvivorData survivorData) {
        log.info("Create Survivor Request: {}", survivorData);
        this.survivorService.createSurvivor(survivorData);
    }


    @PostMapping("report-contamination")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void flagSurvivor(@RequestBody FlagSurvivorRequest request) {
        log.info("Flag Survivor {} Request {}", request.getSurvivorId());
        this.survivorService.flagSurvivor(request);
    }

    @PostMapping("update-location")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateSurvivorLocation(@RequestBody UpdateLocationRequest request) {
        log.info("Update Survivor Location Request {}", request.toString());
        this.survivorService.updateSurvivorLocation(request);
    }
}
