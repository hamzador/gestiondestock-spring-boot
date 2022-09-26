package com.douyry.gestiondestock.controller.api;

import com.douyry.gestiondestock.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.douyry.gestiondestock.utils.Constants.APP_ROOT;

public interface ArticleApi {

    @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto save(@RequestBody ArticleDto articleDto);
    @GetMapping(value = APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto findById(@PathVariable Integer idArticle);
    @GetMapping(value = APP_ROOT + "/articles/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto findByCodeArticle(@PathVariable String codeArticle);
    @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArticleDto> findAll();
    @DeleteMapping(value = APP_ROOT + "/articles/delete/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Integer idArticle);
}
