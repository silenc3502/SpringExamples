package com.example.demo.controller;

import com.example.demo.entity.Music;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Member;

@RestController
@RequestMapping("musics")
public class MusicController {
    final static Logger log =
            LoggerFactory.getLogger(MusicController.class);

    @GetMapping("")
    public ModelAndView musicIndex() {
        log.info("musicIndex()");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("music/musicIndex");

        return modelAndView;
    }

    @GetMapping("/test")
    public Music musicTest() {
        log.info("musicTest()");

        Music music = new Music();

        return music;
    }

    @GetMapping("/play")
    public ModelAndView musicPlay() {
        log.info("musicPlay()");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("music/musicPlay");

        return modelAndView;
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
