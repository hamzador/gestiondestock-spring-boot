package com.douyry.gestiondestock.controller.api;

import com.douyry.gestiondestock.dto.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.douyry.gestiondestock.utils.Constants.APP_ROOT;
@Api("articles")
public interface ArticleApi {

    @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un article", notes = "Cette methode permet d'enregistrer ou modifier un article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet article cree / modifier"),
            @ApiResponse(code = 400, message = "l'objet article n'est pas valide")

    })
    public ArticleDto save(@RequestBody ArticleDto articleDto);
    @GetMapping(value = APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article", notes = "Cette methode permet de rechercher un article par son ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'article est trouvé dans la BD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BD avec l'ID fourni")
    })
    public ArticleDto findById(@PathVariable Integer idArticle);
    @GetMapping(value = APP_ROOT + "/articles/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article par CODE", notes = "Cette methode permet de rechercher un article par son CODE", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'article est trouvé dans la BD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BD avec le CODE fourni")
    })
    public ArticleDto findByCodeArticle(@PathVariable String codeArticle);
    @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des articles", notes = "Cette methode permet de rechercher et renvoyer la liste " +
            "es articles qui exeste dans la BD", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des articles / une liste vide"),
    })
    public List<ArticleDto> findAll();
    @DeleteMapping(value = APP_ROOT + "/articles/delete/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Supprimer un article par ID", notes = "Cette methode permet de supprimer un article par son ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article à été supprime")
    })
    void delete(@PathVariable Integer idArticle);
}
