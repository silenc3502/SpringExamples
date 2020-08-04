package com.example.demo.service;

import com.example.demo.entity.RandNumMessage;
import com.example.demo.repository.RandNumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandNumService {
    static final Logger log =
            LoggerFactory.getLogger(RandNumService.class);

    @Autowired
    private RandNumRepository repository;

    public RandNumMessage getRandom() {
        log.info("Service getRandom()");

        return repository.getRandom();
    }
}
