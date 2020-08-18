package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class HomeNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long homeNewsSeq;

    @Column(length = 20, nullable = false)
    private String homeNewsNo;

    @Column(length = 2000, nullable = false)
    private String image;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 500, nullable = false)
    private String address;

    @Builder
    public HomeNews(String homeNewsNo, String address, String title, String image) {
        this.homeNewsNo = homeNewsNo;
        this.title = title;
        this.address = address;
        this.image = image;
    }
}
