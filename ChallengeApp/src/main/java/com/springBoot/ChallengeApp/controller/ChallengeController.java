package com.springBoot.ChallengeApp.controller;

import com.springBoot.ChallengeApp.entity.Challenge;
import com.springBoot.ChallengeApp.service.ChallengeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChallengeController {

    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }
//
//    public ChallengeController() {
//
//    }

    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        List<Challenge> challengeList = challengeService.getAllChallenges();
        return new ResponseEntity<>(challengeList, HttpStatus.OK);
    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getChallengeById(@PathVariable String challengeMonth) {
        Challenge challenge = challengeService.getChallengeById(challengeMonth);

        if (challenge != null) {
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/challenges")
    public ResponseEntity<String> addChallenges(@RequestBody Challenge challenge) {
        boolean value = challengeService.addChallenge(challenge);

        if (value) {
            return new ResponseEntity<>("Challenge added successfully",
                    HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Challenge not added successfully",
                HttpStatus.NOT_FOUND);
    }

    @PutMapping("/challenges/{challengeId}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long challengeId,
                                                 @RequestBody Challenge updatedChallenge) {
        boolean value = challengeService.updateChallenge(challengeId, updatedChallenge);

        if (value) {
            return new ResponseEntity<>("Challenge updated successfully",
                    HttpStatus.OK);
        }
        return new ResponseEntity<>("Challenge Not Found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/challenges/{challengeId}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long challengeId) {
        boolean value = challengeService.deleteChallenge(challengeId);

        if (value) {
            return new ResponseEntity<>("Challenge deleted successfully",
                    HttpStatus.OK);
        }
        return new ResponseEntity<>("Challenge Not Found", HttpStatus.NOT_FOUND);
    }
}
