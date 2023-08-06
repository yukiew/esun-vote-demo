package com.example.esunvotedemo.dao;

import com.example.esunvotedemo.util.CandidateRowMapper;
import com.example.esunvotedemo.model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CandidateDaoImpl implements CandidateDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Candidate getById(Integer candidateId) {
        String sqlStr = "SELECT id, name, count FROM candidates WHERE id = :candidateId";

        Map<String, Object> map = new HashMap<>();
        map.put("candidateId", candidateId);

        List<Candidate> list = namedParameterJdbcTemplate.query(sqlStr, map, new CandidateRowMapper());

        if (!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public void insert(Candidate candidate) {
        String sqlStr = "INSERT INTO candidates(id, name, count) VALUES (:id, :name, :count)";

        Map<String, Object> map = new HashMap<>();
        map.put("id", candidate.getId());
        map.put("name", candidate.getName());
        map.put("count", candidate.getCount());

        namedParameterJdbcTemplate.update(sqlStr, new MapSqlParameterSource(map));

    }


    @Override
    public void update(Candidate candidate, String person) {
        String sqlStr = "UPDATE candidates SET name = :name, count = :count WHERE id = :id";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", candidate.getName());
        paramMap.put("count", candidate.getCount());
        paramMap.put("id", candidate.getId());

        namedParameterJdbcTemplate.update(sqlStr, paramMap);

        // 返回更新後的候選人資訊，你可以根據需要從資料庫中重新讀取資料或直接返回已更新的 candidate 對象。
    }

    @Override
    public void deleteById(String candidateId) {
        String sqlStr = "DELETE FROM candidates WHERE id = :candidateId";
        Map<String, Object> map = new HashMap<>();
        map.put("candidateId", candidateId);

        namedParameterJdbcTemplate.update(sqlStr, map);
    }


    @Override
    public List<Candidate> getAllCandidates() {
        String sql = "SELECT id, name, count FROM candidates";
        List<Candidate> candidates = namedParameterJdbcTemplate.query(sql, new CandidateRowMapper());
        System.out.println(candidates);
        return candidates;
    }
}
