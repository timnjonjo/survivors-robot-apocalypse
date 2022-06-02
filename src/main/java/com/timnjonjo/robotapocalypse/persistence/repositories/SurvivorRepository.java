package com.timnjonjo.robotapocalypse.persistence.repositories;

import com.timnjonjo.robotapocalypse.persistence.entities.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@Repository
public interface SurvivorRepository extends JpaRepository<Survivor, Long> {

    @Query("SELECT s FROM Survivor s WHERE s.infected= :infected")
    List<Survivor> findByInfected(boolean infected);
}
