package org.example.firstproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.firstproject.dto.ArticleForm;
import org.example.firstproject.entity.Article;
import org.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Slf4j
@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;


    @GetMapping("/articles/new")
    public String newArticleForm() {

        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
//        System.out.printf(form.toString());

        Article article = form.toEntity();
        log.info(article.toString());
//        System.out.printf(article.toString());

        Article saved = articleRepository.save(article);
        log.info(saved.toString());
//        System.out.printf(saved.toString());

        return "";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id" + id);
        // 1. id로 Article 조회
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2. model에 담아서 화면에 전달
        model.addAttribute("article", articleEntity);

        // 3. 화면에서는 model에 담긴 내용을 출력
        return "articles/show";

    }


    @GetMapping("/articles")
    public String index(Model model) {

        // 1. 모든 Article 조회
        ArrayList<Article> articleEntityList = articleRepository.findAll();

        // 2. model에 담아서 화면에 전달
        model.addAttribute("articleList", articleEntityList);

        // 3. 화면에서는 model에 담긴 내용을 출력
        return "articles/index";
    }

}
