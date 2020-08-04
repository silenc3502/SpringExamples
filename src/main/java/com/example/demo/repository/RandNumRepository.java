package com.example.demo.repository;

import com.example.demo.entity.RandNumMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RandNumRepository {
    private static final Logger log =
            LoggerFactory.getLogger(RandNumRepository.class);

    public RandNumMessage getRandom() {
        log.info("Repo getRandom()");

        return new RandNumMessage();
    }
}
