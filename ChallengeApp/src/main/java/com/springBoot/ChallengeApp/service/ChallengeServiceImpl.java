package com.springBoot.ChallengeApp.service;

import com.springBoot.ChallengeApp.entity.Challenge;
import com.springBoot.ChallengeApp.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChallengeServiceImpl implements ChallengeService{

    private Long challengeId = 1L;

    @Autowired
    public ChallengeRepository challengeRepository;

    @Override
    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    @Override
    public Challenge getChallengeById(String month) {
        Optional<Challenge> optionalChallenge =
                challengeRepository.findByMonthIgnoreCase(month);

        return optionalChallenge.orElse(null);
    }

    @Override
    public boolean addChallenge(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(challengeId++);
            challengeRepository.save(challenge);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean updateChallenge(Long challengeId, Challenge updateChallenge) {
        Optional<Challenge> optionalChallenge =
                challengeRepository.findById(challengeId);

        if (optionalChallenge.isPresent()) {
            Challenge challenge = optionalChallenge.get();
            challenge.setMonth(updateChallenge.getMonth());
            challenge.setDescription(updateChallenge.getDescription());

            challengeRepository.save(challenge);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteChallenge(Long challengeId) {
        Optional<Challenge> optionalChallenge =
                challengeRepository.findById(challengeId);

        if (optionalChallenge.isPresent()) {
            challengeRepository.deleteById(challengeId);
            return true;
        }
        return false;
    }
}
