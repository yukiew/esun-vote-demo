package com.example.esunvotedemo.service;

import com.example.esunvotedemo.model.Candidate;

import java.util.List;

public interface CandidateService {


    public Candidate getById(Integer candidateId);

    public void insert(Candidate candidate);

    public void voteByCandidates(List<Candidate> candidates, String person);

    public void deleteById(String candidateId);

    public List<Candidate> getAllCandidates();
}
