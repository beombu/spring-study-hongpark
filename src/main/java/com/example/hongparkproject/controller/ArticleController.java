package com.example.hongparkproject.controller;

import com.example.hongparkproject.dto.ArticleForm;
import com.example.hongparkproject.entity.Article;
import com.example.hongparkproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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

        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id);

        Article articleEntity = articleRepository.findById(id).orElse(null);

        model.addAttribute("article", articleEntity);

        return "articles/show";
    }

    /**
     * 데이터 목록 조회 GET
     */
    @GetMapping("/articles")
    public String index(Model model){
        //1. 모든 Article을 가져온다.
        List<Article> articleEntityList = articleRepository.findAll();

        //2. 가져온 Article 묶음을 뷰로 전달!
        model.addAttribute("articleList", articleEntityList);

        //3. 뷰 페이지를 설정!
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Article articleEntity = articleRepository.findById(id).orElse(null);

        model.addAttribute("article", articleEntity);

        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form){
        log.info(form.toString());

        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());

        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        if (target != null) {
            Article saved = articleRepository.save(articleEntity);
            log.info(saved.toString());
        }

        return "redirect:/articles/" + articleEntity.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {//RedirectAttributes는 메시지 찍어줌
        log.info("삭제 요청");

        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());

        if (target != null) {
            articleRepository.delete(target);
            rttr.addFlashAttribute("mag", "삭제가 완료되었습니다."); //Flash : 휘발성!! 한번만쓰고 삭제
        }

        return "redirect:/articles";
    }
}
