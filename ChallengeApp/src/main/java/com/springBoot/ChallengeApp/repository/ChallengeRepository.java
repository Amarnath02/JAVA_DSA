package com.springBoot.ChallengeApp.repository;

import com.springBoot.ChallengeApp.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    Optional<Challenge> findByMonthIgnoreCase(String month);
}
