package com.example.hongparkproject.controller;

import com.example.hongparkproject.dto.ArticleForm;
import com.example.hongparkproject.entity.Article;
import com.example.hongparkproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ArticleController {

    @Autowired // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결 == DI!! (생성자 주입)
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticlesForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        //System.out.println(form.toString()); log로 변경
        log.info(form.toString());

        // 1. Dto -> Entity로 변환!
        Article article = form.toEntity();
        //System.out.println(article.toString());
        log.info(article.toString());

        // 2. Repository에게 Entity를 DB안에 저장하게 함!
        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString());
        log.info(saved.toString());

        return "";
    }
}
