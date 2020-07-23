package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("musics")
public class MusicController {
    final static Logger log =
            LoggerFactory.getLogger(MusicController.class);

    @GetMapping("")
    public String musicIndex() {
        log.info("musicIndex()");

        return "music/musicIndex";
    }

    @GetMapping("/play")
    public String musicPlay() {
        log.info("musicPlay()");

        return "music/musicPlay";
    }

    @GetMapping("/menu")
    public String musicMenu() {
        log.info("musicMenu()");

        return "music/musicMenu";
    }

    @GetMapping("/record")
    public String musicRecord() {
        log.info("musicRecord()");

        return "music/musicRecord";
    }

}
