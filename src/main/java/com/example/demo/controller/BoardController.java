package com.example.demo.controller;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    private static final Logger log =
            LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService service;

    @GetMapping("/getRegister")
    public String getRegister(Board board, Model model)
                                    throws Exception {
        log.info("getRegister()");

        return "board/register";
    }

    @PostMapping("/postRegister")
    public String postRegister(Board board, Model model)
                                        throws Exception {
        log.info("postRegister()");

        service.register(board);

        model.addAttribute(
                "msg",
                "Register Success");

        return "board/success";
    }

    // URL 맵핑
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        log.info("list()");

        // 속성 추가(이름: list)
        // Controller -> Service -> Repository 방식으로
        // 동작하게 설계되어 있다.
        // DB에서 읽어온 정보
        model.addAttribute(
                "list",
                service.list());

        // HTML 파일
        return "board/list";
    }

    @GetMapping("/read")
    public String read(int boardNo, Model model)
                            throws Exception {
        log.info("read()");

        model.addAttribute(service.read(boardNo));

        return "board/read";
    }

    @PostMapping("/remove")
    public String remove(int boardNo, Model model)
                                    throws Exception {
        log.info("remove()");

        service.remove(boardNo);

        model.addAttribute("msg",
                "Success Delete!");

        return "board/success";
    }

    @GetMapping("/getModify")
    public String modify(int boardNo, Model model)
                                        throws Exception {
        log.info("getModify()");

        model.addAttribute(service.read(boardNo));
        return "board/modify";
    }

    @PostMapping("/postModify")
    public String modify(Board board, Model model)
                                        throws Exception {
        log.info("postModify()");

        service.modify(board);
        model.addAttribute("msg",
                "Modify Success");
        return "board/success";
    }
}

// 여태까지 MySQL과 Spring을 연동하는 방식을 파악하였다.
// 그러므로 현재 예제를 토대로 유사한 연습문제를 작성해보자!
// 1. MySQL에 table을 작성한다.
//    (Entity: ItemMania
//     id, pw, nickname, item, price)
// 2. entity 패키지에 실제 사용할 Entity 클래스를 작성한다.
// 3. controller 패키지에
//    URL을 처리할 ItemManiaController를 만든다.
// 4. @Service에 대한 인터페이스와 구현체를 작성한다.
// 5. @Repository에 대한 DB 처리를 실제로 수행한다.
// 6. 각각의 필요한 HTML 파일들을 작성한다.
// 7. HTML 연동 순서
// 7-1. list(모든 게시글을 확인할 수 있는 형태)
// 7-2. register(게시글을 등록할 수 있도록 만든다)
// 7-3. remove(게시글을 삭제할 수 있도록 만들어본다)
// 7-4. read(게시글을 실제로 읽을 수 있도록 만들어본다)
// 7-5. modify(게시글을 수정할 수 있도록 만들어본다)
