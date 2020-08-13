package com.example.demo.repository;

import com.example.demo.entity.MemberAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MemberAuthRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MemberAuth checkAuth(Long userNo) throws Exception {
        List<MemberAuth> results = jdbcTemplate.query(
            "select user_no, auth from member_auth where user_auth_no = ?",
            new RowMapper<MemberAuth>() {
                @Override
                public MemberAuth mapRow(ResultSet rs, int rowNum) throws SQLException {
                    MemberAuth mAuth = new MemberAuth();

                    mAuth.setUserNo(rs.getLong("user_no"));
                    mAuth.setAuth(rs.getString("auth"));

                    return mAuth;
                }
            }, userNo
        );

        return results.isEmpty() ? null : results.get(0);
    }
}
