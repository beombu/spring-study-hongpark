package com.example.hongparkproject.repository;

import com.example.hongparkproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> {
}
