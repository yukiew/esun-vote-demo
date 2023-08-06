package com.example.esunvotedemo.dao;

import com.example.esunvotedemo.model.Candidate;

import java.util.List;

public interface CandidateDao {
    public Candidate getById(Integer CandidateId);

    public void insert(Candidate candidate);

    public void update(Candidate candidate, String person);

    public void deleteById(String candidateId);

    public List<Candidate> getAllCandidates();
}
