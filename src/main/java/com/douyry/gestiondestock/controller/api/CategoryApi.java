package com.douyry.gestiondestock.controller.api;

import com.douyry.gestiondestock.dto.ArticleDto;
import com.douyry.gestiondestock.dto.CategoryDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.douyry.gestiondestock.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/categories")
public interface CategoryApi {

    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une catégorie", notes = "Cette methode permet d'enregistrer ou modifier une catégorie", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet category cree / modifier"),
            @ApiResponse(code = 400, message = "l'objet category n'est pas valide")

    })
    CategoryDto save(@RequestBody CategoryDto dto);


    @GetMapping(value = APP_ROOT + "/categories/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une categorie", notes = "Cette methode permet de rechercher une categorie par son ID", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la categorie est trouvé dans la BD"),
            @ApiResponse(code = 404, message = "Aucune categorie n'existe dans la BD avec l'ID fourni")
    })
    CategoryDto findById(@PathVariable Integer idCategory);

    @GetMapping(value = APP_ROOT + "/categories/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une categorie par CODE",
            notes = "Cette methode permet de rechercher une categorie par son CODE",
            response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la categorie est trouvé dans la BD"),
            @ApiResponse(code = 404, message = "Aucune categorie n'existe dans la BD avec le CODE fourni")
    })
    CategoryDto findByCode(@ApiParam(value = "Accepted values [cat, cat2, cat3]") @PathVariable String codeCategory);

    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des categories",
            notes = "Cette methode permet de rechercher et renvoyer la liste " +
            "des categories qui exeste dans la BD", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des categories / une liste vide"),
    })
    List<CategoryDto> findAll();


    @DeleteMapping(value = APP_ROOT + "/categories/delete/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Supprimer une categorie par ID",
            notes = "Cette methode permet de supprimer une categorie par son ID",
            responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La categorie à été supprimé")
    })
    void delete(@PathVariable Integer idCategory);

}
