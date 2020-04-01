package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
// finding the whisky by year.
    List<Whisky> findWhiskyByYear(int years);

    List<Whisky> findWhiskyByDistilleryNameAndAge(String distilleryName, int age);

    List<Whisky> findWhiskyByDistilleryRegion(String distilleryRegion);
}
