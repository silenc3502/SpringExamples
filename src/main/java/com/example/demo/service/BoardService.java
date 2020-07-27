package com.example.demo.service;

import com.example.demo.entity.Board;

import java.util.List;

// interface 사용 이유: 다형성
// A - test(), B - test(), C - test()
// 각각의 이름을 통일하면서 사용 방식은 다르게 사용
// 데이터 처리의 일관성을 제공해줄 수 있다.
public interface BoardService {
    // DB 처리할 때 오류가 발생할 수 있으므로
    // 예외 처리 루틴에게 해당 부분의 처리를 위임
    public void register(Board board) throws Exception;
    public List<Board> list() throws Exception;
    public Board read(Integer boardNo) throws Exception;
    public void remove(Integer boardNo) throws Exception;
    public void modify(Board board) throws Exception;
}
