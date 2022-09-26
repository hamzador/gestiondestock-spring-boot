package com.douyry.gestiondestock.service;

import com.douyry.gestiondestock.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    public ArticleDto save(ArticleDto articleDto);
    public ArticleDto findById(Integer id);
    public ArticleDto findByCodeArticle(String codeArticle);
    public List <ArticleDto> findAll();
    void delete(Integer Id);
}
