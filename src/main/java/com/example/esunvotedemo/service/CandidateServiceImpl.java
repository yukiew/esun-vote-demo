package com.example.esunvotedemo.service;

import com.example.esunvotedemo.dao.CandidateDao;
import com.example.esunvotedemo.dao.VoteRecordsDao;
import com.example.esunvotedemo.model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    public CandidateDao candidateDao;

    @Autowired
    public VoteRecordsDao voteRecordsDao;

    @Override
    public Candidate getById(Integer candidateId) {
        return candidateDao.getById(candidateId);
    }

    @Override
    public void insert(Candidate candidate) {
        candidateDao.insert(candidate);
    }

    @Override
    @Transactional
    public void voteByCandidates(List<Candidate> candidates, String person) {
        for (Candidate candidate : candidates) {
            // 更新候选人信息
            candidate.setCount(candidate.getCount()+1);
            candidateDao.update(candidate, person);
            voteRecordsDao.insertVoteRecord(candidate.getId(), person);
        }
    }
    @Override
    public void deleteById(String candidateId) {
        candidateDao.deleteById(candidateId);
        voteRecordsDao.deleteVoteRecordByCandidateId(candidateId);
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateDao.getAllCandidates();
    }
}
