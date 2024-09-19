package com.springBoot.ChallengeApp.service;

import com.springBoot.ChallengeApp.entity.Challenge;

import java.util.List;

public interface ChallengeService {

    List<Challenge> getAllChallenges();
    Challenge getChallengeById(String month);
    boolean addChallenge(Challenge challenge);
    boolean updateChallenge(Long id, Challenge challenge);
    boolean deleteChallenge(Long challengeId);
}
