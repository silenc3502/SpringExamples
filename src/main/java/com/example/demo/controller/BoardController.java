package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    private static final Logger log =
            LoggerFactory.getLogger(BoardController.class);

    private BoardService service;

    @GetMapping("/getRegister")
    public void getRegister(Board board, Model model) {
        log.info("getRegister()");
    }

    @PostMapping("/postRegister")
    public String postRegister(Board board, Model model) {
        log.info("postRegister()");

        service.register(board);

        model.addAttribute(
                "msg",
                "Register Success");

        return "board/success";
    }

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list()");

        model.addAttribute(
                "list",
                service.list());
    }
}
