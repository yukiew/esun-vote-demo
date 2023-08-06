package com.example.esunvotedemo.util;

import com.example.esunvotedemo.model.Candidate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidateRowMapper implements RowMapper<Candidate> {
    @Override
    public Candidate mapRow(ResultSet resultSet, int i) throws SQLException {
        Candidate candidate = new Candidate();
        candidate.setId(resultSet.getString("id"));
        candidate.setName(resultSet.getString("name"));
        candidate.setCount(resultSet.getInt("count"));
        return candidate;
    }
}
