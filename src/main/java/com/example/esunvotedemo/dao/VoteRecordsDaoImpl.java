package com.example.esunvotedemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class VoteRecordsDaoImpl implements VoteRecordsDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public VoteRecordsDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void insertVoteRecord(String candidateId, String person) {
        String sql = "INSERT INTO vote_records (person, cid) VALUES (:person, :candidateId)";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("person", person);
        paramMap.put("candidateId", candidateId);

        namedParameterJdbcTemplate.update(sql, paramMap);
    }
    @Override
    public void deleteVoteRecordByCandidateId(String candidateId) {
        String sql = "DELETE FROM vote_records WHERE cid = :candidateId";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("candidateId", candidateId);

        namedParameterJdbcTemplate.update(sql, paramMap);
    }
}
