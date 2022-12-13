package com.douyry.gestiondestock.controller;

import com.douyry.gestiondestock.controller.api.ArticleApi;
import com.douyry.gestiondestock.dto.ArticleDto;
import com.douyry.gestiondestock.dto.LigneCommandeClientDto;
import com.douyry.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.douyry.gestiondestock.dto.LigneVenteDto;
import com.douyry.gestiondestock.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        return articleService.save(articleDto);
    }

    @Override
    public ArticleDto findById(Integer idArticle) {
        return articleService.findById(idArticle);
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
        return null;
    }

    @Override
    public List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle) {
        return null;
    }

    @Override
    public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle) {
        return null;
    }

    @Override
    public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
        return null;
    }

    @Override
    public void delete(Integer idArticle) {
        articleService.delete(idArticle);
    }


}
