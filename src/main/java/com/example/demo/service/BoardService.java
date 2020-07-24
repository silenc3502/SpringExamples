package com.example.demo.service;

import com.example.demo.entity.Board;

import java.util.List;

public interface BoardService {
    public void register(Board board) throws Exception;
    public List<Board> list() throws Exception;
}
