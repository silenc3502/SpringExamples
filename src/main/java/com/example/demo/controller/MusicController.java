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
import java.util.ArrayList;
import java.util.List;

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
    public ModelAndView musicMenu() {
        log.info("musicMenu()");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("music/musicMenu");

        return modelAndView;
    }

    @GetMapping("/record")
    public ModelAndView musicRecord() {
        log.info("musicRecord()");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("music/musicRecord");

        return modelAndView;
    }

    @GetMapping("/titles")
    public List<Music> musicTitles() {
        log.info("musicTitles()");

        List<Music> list = new ArrayList<Music>();

        Music music1 = new Music();
        list.add(music1);

        Music music2 = new Music();
        list.add(music2);

        return list;
    }
}
