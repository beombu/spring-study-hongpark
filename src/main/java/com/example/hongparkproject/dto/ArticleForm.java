package com.example.hongparkproject.dto;

import com.example.hongparkproject.entity.Article;

public class ArticleForm {

    private String title;
    private String content;

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    /**
     * Dto를 Entity로 변환해주는 메소드
     * @return
     */
    public Article toEntity() {
        return new Article(null, title, content);
    }
}
