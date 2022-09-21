package com.douyry.gestiondestock.service.impl;

import com.douyry.gestiondestock.dto.ArticleDto;
import com.douyry.gestiondestock.exception.EntityNotFoundException;
import com.douyry.gestiondestock.exception.ErrorCodes;
import com.douyry.gestiondestock.exception.InvalidEntityException;
import com.douyry.gestiondestock.model.Article;
import com.douyry.gestiondestock.repository.ArticleRepository;
import com.douyry.gestiondestock.service.ArticleService;
import com.douyry.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", articleDto);
            throw new InvalidEntityException("L'article n'est pas valid", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }

        Article savedArticle = articleRepository.save(ArticleDto.toEntity(articleDto));
        return ArticleDto.fromEntity(savedArticle);
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }
        Optional<Article> article = articleRepository.findById(id);
        ArticleDto articleDto = ArticleDto.fromEntity(article.get());
        return Optional.of(articleDto).orElseThrow(
                () -> new EntityNotFoundException(
                        "Aucun article avec l'ID = " + id + "n'été trouvé dans la base de données",
                        ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return null;
    }

    @Override
    public List<ArticleDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer Id) {

    }
}
