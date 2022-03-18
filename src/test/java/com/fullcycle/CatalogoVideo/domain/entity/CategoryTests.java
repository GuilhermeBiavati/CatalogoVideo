package com.fullcycle.CatalogoVideo.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fullcycle.CatalogoVideo.domain.exception.NotBlankException;
import com.fullcycle.CatalogoVideo.domain.exception.NotNullException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// @ExtendWith(SpringExtension.class)
// @SpringBootTest
public class CategoryTests {

    @Test
    public void throwDomainExceptionWhenNameIsNull() {
        assertThrows(NotNullException.class, () -> new Category(null, "description"));
    }

    @Test
    public void throwDomainExceptionWhenNameIsBlank() {
        assertThrows(NotBlankException.class, () -> new Category("", "description"));
    }

    @Test
    public void createCategoryWithNameAndDescriptionNull() {
        final Category entity = new Category("Name 1", null);
        assertNotNull(entity);
        assertEquals("Name 1", entity.getName());
        assertNull(entity.getDescription());
    }

    @Test
    public void createCategoryWithNameAndDescription() {
        final Category entity = new Category("Name 1", "Descripion");
        assertNotNull(entity);
        assertEquals("Name 1", entity.getName());
        assertEquals("Descripion", entity.getDescription());
    }

    @Test
    public void createCategoryAndActiveTrue() {
        final Category entity = new Category("Name 1", "Descripion");
        assertNotNull(entity);
        assertTrue(entity.getIsActive());
    }

    @Test
    public void createCategoryAndActiveFalse() {
        final Category entity = new Category("Name 1", "Descripion");
        assertNotNull(entity);
        entity.deactive();
        assertFalse(entity.getIsActive());
    }

    @Test
    public void createCategoryAndUpdate() {
        final Category entity = new Category("Name 1", "Descripion");
        assertNotNull(entity);
        entity.update("Name 2", "Description 2", false);
        assertNotNull(entity);
        assertEquals("Name 2", entity.getName());
        assertEquals("Description 2", entity.getDescription());
        assertFalse(entity.getIsActive());
    }

}
