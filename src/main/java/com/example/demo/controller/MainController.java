package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class MainController {
    static final Logger log =
            LoggerFactory.getLogger(MainController.class);

    // localhost:8080/으로 접속하면
    // 제어 유닛이 아래 코드를 실행시킨다.
    @GetMapping("/")
    public String index(Locale locale, Model model) {
        log.info("index()");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(
                DateFormat.LONG, DateFormat.LONG, locale
        );

        String formattedDate = dateFormat.format(date);
        model.addAttribute("servTime", formattedDate);

        // index.html을 보여준다.
        return "index";
    }
}
