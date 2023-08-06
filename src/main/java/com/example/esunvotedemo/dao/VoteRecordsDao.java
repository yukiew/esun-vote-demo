package com.example.esunvotedemo.dao;

public interface VoteRecordsDao {
    public void insertVoteRecord(String candidateId, String person);
    public void deleteVoteRecordByCandidateId(String candidateId);
}
