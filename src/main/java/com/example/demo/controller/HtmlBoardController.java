package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class HtmlBoardController {
    private static final Logger logger =
            LoggerFactory.getLogger(HtmlBoardController.class);
    @GetMapping(value = "/get", params = "register")
    public String getRegister() {
        logger.info("getRegister()");

        return "register";
    }

    @GetMapping(value = "/get", params = "read")
    public String getRead() {
        logger.info("getRead()");

        return "htmlRead";
    }

    @GetMapping("/html/register")
    public String registerForm() {
        logger.info("registerForm");

        return "htmlRegister";
    }

    @PostMapping("/html/register")
    public String register() {
        logger.info("register(POST)");

        return "htmlRegister";
    }

    @GetMapping("/html/modify")
    public String modifyForm() {
        logger.info("modifyForm()");

        return "htmlModifyForm";
    }

    @PostMapping("/html/modify")
    public String modify() {
        logger.info("modify(POST)");

        return "htmlModifyForm";
    }

    @PostMapping("/html/delete")
    public String deleteForm() {
        logger.info("deleteForm()");

        return "htmlDeleteForm";
    }

    @GetMapping("/html/list")
    public String listForm() {
        logger.info("listForm()");

        return "htmlListForm";
    }

    @GetMapping("/html/board/read/{boardNo}")
    public String readForm(
            // 모든 게시판에는 게시판 번호가 있다.
            // PathVariable을 통해 가변 번호를 받을 수 있게 만든다.
            @PathVariable("boardNo") int boardNo) {
        logger.info("readForm: " + boardNo);

        return "htmlRead";
    }

    @GetMapping("/regtestpage")
    public String registerTestPage() {
        logger.info("registerTestPage()");

        return "form/registerForm";
    }

    @PostMapping("/regtest")
    public String registerTest(String userId, String passwd) {
        logger.info("registerTest()");

        logger.info("userId = " + userId);
        logger.info("passwd = " + passwd);

        return "form/success";
    }

    @GetMapping("/getRegTest")
    public String getRegTest(String userId, Date date) {
        logger.info("getRegTest()");
        logger.info("userId = " + userId);
        logger.info("date = " + date);

        return "form/success";
    }
}

// MusicController를 하나 만든다.
// Controller 기능으로는 음악 재생, 메뉴 보기, 녹음
// 이와 관련된 HTML 및 Controller 구성을 직접 해보자!
// (음악이 재생, 녹음 등등이 될 필요는 없다)

// DB 접속하기
// mysql -u bitai -p

// 계정이 터진 경우
// sudo mysql -u root -p
// 계정 비밀번호 입력함
// create user bitai@localhost identified by '456123';
// grant all privileges on testdb.* to bitai@localhost identified by '456123';
// exit
// mysql -u bitai -p