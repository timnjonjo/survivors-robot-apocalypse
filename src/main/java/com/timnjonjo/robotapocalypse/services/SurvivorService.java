package com.timnjonjo.robotapocalypse.services;

import com.timnjonjo.robotapocalypse.exceptions.NoSurvivorFoundException;
import com.timnjonjo.robotapocalypse.models.FlagSurvivorRequest;
import com.timnjonjo.robotapocalypse.models.SurvivorData;
import com.timnjonjo.robotapocalypse.models.SurvivorsSummary;
import com.timnjonjo.robotapocalypse.models.UpdateLocationRequest;
import com.timnjonjo.robotapocalypse.persistence.entities.Location;
import com.timnjonjo.robotapocalypse.persistence.entities.Survivor;
import com.timnjonjo.robotapocalypse.persistence.repositories.SurvivorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@Service
@Slf4j
public class SurvivorService {

    private final SurvivorRepository survivorRepository;


    public Survivor getSurvivor(Long survivorId) {
        return this.survivorRepository.findById(survivorId).orElseThrow(() -> new NoSurvivorFoundException(survivorId));
    }

    public SurvivorService(SurvivorRepository survivorRepository) {
        this.survivorRepository = survivorRepository;
    }

    public void createSurvivor(final SurvivorData survivorData) {
        this.survivorRepository.save(survivorData.transform());
        log.info("Survivor: {} created", survivorData.getFullname());
    }

    public void flagSurvivor(final FlagSurvivorRequest request) {
        Survivor survivor = getSurvivor(request.getSurvivorId());
        survivor.flag();
        this.survivorRepository.save(survivor);
        log.info("Survivor: {} Flagged Infected", survivor.getId());
    }

    public void updateSurvivorLocation(final UpdateLocationRequest request) {
        Survivor survivor = getSurvivor(request.getSurvivorId());
        survivor.updateLocation(new Location(request.getLatitude(), request.getLongitude()));
        this.survivorRepository.save(survivor);
        log.info("Survivor: {} Location Updated", request.getSurvivorId());
    }

    public List<SurvivorData> getSurvivors(boolean infected) {
        return this.survivorRepository.findByInfected(infected).stream().map(Survivor::transform).collect(Collectors.toList());
    }

    public SurvivorsSummary getSummary() {
        final List<Survivor> survivors = survivorRepository.findAll();
        if (survivors.isEmpty()) throw new NoSurvivorFoundException();
        final int total = survivors.size();
        final int infected = Math.toIntExact(survivors.stream().filter(Survivor::isInfected).count());
        final double percentageInfected = calculatePercentage(infected, total);

        SurvivorsSummary summary = new SurvivorsSummary();
        summary.setTotalSurvivors(survivors.size());
        summary.setInfectedSurvivors(percentageInfected);
        summary.setNonInfectedSurvivors(100 - percentageInfected);

        return summary;
    }

    private double calculatePercentage(double value, double total) {
        return value * 100 / total;
    }
}

