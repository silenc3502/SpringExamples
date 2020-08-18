package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class ClickedNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clickedNewsSeq;

    @Column(length = 20, nullable = false)
    private String clickedNewsNo;

    @Column(length = 200, nullable = false)
    private String date;

    @Column(length = 20, nullable = false)
    private String category;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 10000, nullable = false)
    private String contents;

    @Column(length = 500, nullable = false)
    private String address;

    @Builder
    public ClickedNews(String date, String category, String title, String contents, String address) {
        this.date = date;
        this.category = category;
        this.title = title;
        this.contents = contents;
        this.address = address;
    }
}
