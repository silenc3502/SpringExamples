package com.example.demo.controller;

import com.example.demo.entity.VueBoard;
import com.example.demo.service.VueBoardService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Log
@RestController
@RequestMapping("/boards")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueBoardController {
    //static final Logger log = LoggerFactory.getLogger(VueBoardController.class);

    @Autowired
    private VueBoardService service;

    @GetMapping("/{boardNo}")
    public ResponseEntity<VueBoard> read(
            @PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("read()");

        VueBoard board = service.read(boardNo);

        return new ResponseEntity<VueBoard>(board, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<VueBoard>> list() throws Exception {
        log.info("list()");

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> register(
            @Validated @RequestBody VueBoard board,
            UriComponentsBuilder uriBuilder) throws Exception {
        log.info("register()");

        service.register(board);

        log.info("register board.getBoardNo() = " + board.getBoardNo());

        URI resourceURI = uriBuilder.path("boards/{boardNo}")
                .buildAndExpand(board.getBoardNo())
                .encode()
                .toUri();

        return ResponseEntity.created(resourceURI).build();
    }

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<Void> remove(
            @PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("remove");

        service.remove(boardNo);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{boardNo}")
    public ResponseEntity<Void> modify(
            @PathVariable("boardNo") Long boardNo,
            @Validated @RequestBody VueBoard board) throws Exception {
        log.info("modify()");

        board.setBoardNo(boardNo);
        service.modify(board);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
