package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// DB 처리에 대한 어노테이션(Component)
@Repository
// BoardDataAccessObject(BoardDAO)
public class BoardRepository {
    static final Logger log =
            LoggerFactory.getLogger(BoardRepository.class);

    // JdbcTemplate은 DB Query를 생성하는데 활용한다.
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Board board) throws Exception {
        log.info("Repository create()");

        // insert는 데이터를 입력함
        // board는 create table로 만든 내용
        // board에 있는 title, content, writer에
        // 특정값 3 개를 삽입하기 위해 ?, ?, ?를 셋팅한 상태
        String query = "insert into board(" +
            "title, content, writer) values(?, ?, ?)";
        // 아래 getter를 이용해서 ? 부분들의 값을 채운다.
        // 즉 물음표가 2개면 getter도 2개를 사용하면 된다.
        jdbcTemplate.update(query, board.getTitle(),
                board.getContent(), board.getWriter());
    }

    public List<Board> list() throws Exception {
        log.info("Repository list()");

        // select는 값을 선택해오는 녀석이고
        // board, title ... 등등은 board에 있는 정보들
        // 조건을 줄 때 where를 사용한다.
        // board_no가 0 보다 크다는 조건을 가지고 있음
        // order by는 정렬 조건에 해당한다.
        // board_no, reg_date에 대해 정렬 조건을 줬음
        List<Board> results = jdbcTemplate.query(
            "select board_no, title, content, " +
                    "writer, reg_date from board " +
                    "where board_no > 0 order by " +
                    "board_no desc, reg_date desc",
            new RowMapper<Board>() {
                @Override
                public Board mapRow(ResultSet rs, int rowNum)
                                        throws SQLException {
                    Board board = new Board();
                    board.setBoardNo(rs.getInt("board_no"));
                    board.setTitle(rs.getString("title"));
                    board.setContent(rs.getString("content"));
                    board.setWriter(rs.getString("writer"));
                    board.setRegDate(rs.getDate("reg_date"));
                    return board;
                }
            });

        return results;
    }

    public Board read(Integer boardNo) throws Exception {
        // 특정한 board 번호를 가지고
        // 번호, 제목, 내용, 저자, 등록일을 가져오는 작업
        List<Board> results = jdbcTemplate.query(
            "select board_no, title, content, writer, " +
                    "reg_date from board where board_no = ?",
            new RowMapper<Board>() {
                @Override
                public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Board board = new Board();

                    board.setBoardNo(rs.getInt("board_no"));
                    board.setTitle(rs.getString("title"));
                    board.setWriter(rs.getString("writer"));
                    board.setContent(rs.getString("content"));
                    board.setRegDate(rs.getDate("reg_date"));

                    return board;
                }
            }, boardNo
        );

        // 처리한 결과가 아무것도 없다면 null 리턴하고
        // 만약 결과가 나왔다면 처리한 결과의 첫번째 행을 리턴한다.
        // 0은 첫번째 행을 의미함
        return results.isEmpty() ? null : results.get(0);
    }

    public void remove(Integer boardNo) throws Exception {
        // DB 테이블 안에 있는 내용을 지울때는 delete를 사용한다.
        String query = "delete from board where board_no = ?";
        jdbcTemplate.update(query, boardNo);
    }

    public void modify(Board board) throws Exception {
        // update는 DB 테이블의 내용을 갱신하는데 사용한다.
        // update 테이블명 set 이후에 고칠값들, 필요하다면 조건이 붙음
        String query = "update board set title = ?, content = ? " +
                        "where board_no = ?";
        jdbcTemplate.update(
                query, board.getTitle(),
                board.getContent(), board.getBoardNo()
        );
    }
}
