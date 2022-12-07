package com.example.hongparkproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // DB가 해당 객체를 인식할 수 있다.
@AllArgsConstructor
@ToString
@Getter
@NoArgsConstructor
public class Article {

    @Id //기본키 설정
    @GeneratedValue // 1,2,3 ... 자동 생성 어노테이션
    private Long id;

    @Column//행으로 선언
    private String title;

    @Column
    private String content;

}
