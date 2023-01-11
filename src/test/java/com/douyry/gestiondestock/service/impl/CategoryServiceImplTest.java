package com.douyry.gestiondestock.service.impl;

import com.douyry.gestiondestock.dto.CategoryDto;
import com.douyry.gestiondestock.exception.ErrorCodes;
import com.douyry.gestiondestock.exception.InvalidEntityException;
import com.douyry.gestiondestock.service.CategoryService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void shouldSaveCategory(){
        CategoryDto expectedCategory = CategoryDto.builder()
                .code("code_1")
                .designation("designation")
                .idEntreprise(1)
                .build();
        CategoryDto savedCategory = categoryService.save(expectedCategory);

        //
        Assertions.assertNotNull(savedCategory);
        Assertions.assertNotNull(savedCategory.getId());
        Assertions.assertEquals(savedCategory.getCode(), expectedCategory.getCode());
        Assertions.assertEquals(savedCategory.getDesignation(), expectedCategory.getDesignation());
        Assertions.assertEquals(savedCategory.getIdEntreprise(), expectedCategory.getIdEntreprise());
    }

    @Test
    public void shouldUpdateCategory(){
        CategoryDto expectedCategory = CategoryDto.builder()
                .code("code_1")
                .designation("designation")
                .idEntreprise(1)
                .build();
        CategoryDto savedCategory = categoryService.save(expectedCategory);
        CategoryDto updateCategory = savedCategory;
        updateCategory.setCode("updatedCode");

        savedCategory = categoryService.save(updateCategory);

        Assertions.assertNotNull(updateCategory);
        Assertions.assertNotNull(updateCategory.getId());
        Assertions.assertEquals(updateCategory.getCode(), savedCategory.getCode());
        Assertions.assertEquals(updateCategory.getDesignation(), savedCategory.getDesignation());
        Assertions.assertEquals(updateCategory.getIdEntreprise(), savedCategory.getIdEntreprise());
    }

    @Test
    public void shouldThrowInvalidEntityException(){
        CategoryDto expectedCategory = CategoryDto.builder().build();

        InvalidEntityException expectedException = assertThrows(InvalidEntityException.class, () -> categoryService.save(expectedCategory));

        assertEquals(ErrorCodes.CATEGORY_NOT_VALID, expectedException.getErrorCode());
        assertEquals(1,expectedException.getErrors().size());
        assertEquals("Veuillez renseigner le code de la categorie",expectedException.getErrors().get(0));
    }


}