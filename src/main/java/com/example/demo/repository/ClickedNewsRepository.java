package com.example.demo.repository;

import com.example.demo.entity.ClickedNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClickedNewsRepository extends JpaRepository<ClickedNews, Long> {
    public ClickedNews findByClickedNewsNo(String clickedNewsNo);
}
