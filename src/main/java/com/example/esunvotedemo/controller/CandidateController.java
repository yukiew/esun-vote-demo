package com.example.esunvotedemo.controller;

import com.example.esunvotedemo.model.Candidate;
import com.example.esunvotedemo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Validated
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @PostMapping("/candidate/create")
    public void create(@RequestBody Candidate candidate) {
        System.out.println("create");
        candidateService.insert(candidate);
    }

    @GetMapping ("/candidate/all")
    public List<Candidate> readAll() {
        System.out.println("readAll");

        return candidateService.getAllCandidates();
    }

    @PostMapping("/candidate/update")
    public void update(@RequestBody @Valid List<Candidate> candidates, @RequestParam @NotBlank String person) {
        candidateService.voteByCandidates(candidates, person);
    }


    @DeleteMapping("/candidate/{candidateId}")
    public void delete(@PathVariable @NotBlank String candidateId) {
        candidateService.deleteById(candidateId);
    }
}