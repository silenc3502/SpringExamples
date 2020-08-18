package com.example.demo.repository;

import com.example.demo.entity.HomeNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeNewsRepository extends JpaRepository<HomeNews, Long> {
}
