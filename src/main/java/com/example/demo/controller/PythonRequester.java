package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PythonRequester {
    final static Logger log =
            LoggerFactory.getLogger(PythonRequester.class);

    // RequestMapping value는
    // 결국 URL 주소에 해당한다.
    // 그러므로 localhost:8080/doRequestPythonRest
    // 이것이 URL 요청으로 들어가면 아래 함수가 동작한다.
    @RequestMapping(
            value = "/doRequestPythonRest",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET
    )
    public ModelAndView doRequestPythonRest(Model model) {
        log.info("doRequestPythonRest()");

        List<HttpMessageConverter<?>> converters =
                new ArrayList<HttpMessageConverter<?>>();
        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);

        MultiValueMap<String, String> map =
                new LinkedMultiValueMap<String, String>();
        map.add("str", "request test");

        // Python Flask 서버의 5000번에
        // dataServer URL을 요청하는 작업
        String result = restTemplate.getForObject(
                "http://localhost:5000/dataServer",
                String.class
        );

        log.info("result = " + result);

        // 이 녀석의 처리 결과는 pyResult.html에서 확인하라는 의미
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pyResult");

        // RestFUL 서버에 요청을 보내 받아온 정보가 result인데
        // 이 정보를 msg라는 속성값에 할당했다.
        // 그러므로 사용하고자 한다면 html 코드에서 msg를 활용해야 한다.
        model.addAttribute("msg", result);

        return modelAndView;
    }
}
