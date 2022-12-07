package com.example.hongparkproject.dto;

import com.example.hongparkproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {

    private Long id;
    private String title;
    private String content;

    /**
     * Dto를 Entity로 변환해주는 메소드
     * @return
     */
    public Article toEntity() {
        return new Article(id, title, content);
    }
}
