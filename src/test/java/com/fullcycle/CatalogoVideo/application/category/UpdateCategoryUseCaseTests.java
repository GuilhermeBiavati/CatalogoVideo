package com.fullcycle.CatalogoVideo.application.category;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import com.fullcycle.CatalogoVideo.application.exception.NotFoundException;
import com.fullcycle.CatalogoVideo.application.usecase.category.update.UpdateCategoryInputData;
import com.fullcycle.CatalogoVideo.application.usecase.category.update.UpdateCategoryUseCase;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class UpdateCategoryUseCaseTests {

    @InjectMocks
    private UpdateCategoryUseCase useCase;

    @Mock
    ICategoryRepository repository;

    @BeforeEach
    void initUsaCase() {
        useCase = new UpdateCategoryUseCase(repository);
    }

    @Test
    public void executeReturnsUpdatedCategoryName() throws Exception {
        Category category = new Category("Action", "description", false);
        Category expectedCategory = new Category("Adventure", "description", true);

        Optional<Category> opCategory = Optional.of(category);

        when(repository.findById(category.getId())).thenReturn(opCategory);

        UpdateCategoryInputData input = new UpdateCategoryInputData();
        input.setName("Adventure");
        input.setDescription("description");
        input.setIsActive(true);

        category.update(input.getName(), input.getDescription(), input.getIsActive());

        doNothing().when(repository).update(category);

        useCase.execute(category.getId(), input);

        assertThat(category).isNotNull();
        assertThat(category.getName()).isEqualTo(expectedCategory.getName());
        assertThat(category.getDescription()).isEqualTo(expectedCategory.getDescription());
        assertThat(category.getIsActive()).isEqualTo(expectedCategory.getIsActive());
        assertThat(expectedCategory).isNotNull();
    }

    @Test
    public void executeReturnsUpdatedCategory() throws Exception {
        Category category = new Category("Action", "description", false);
        Category expectedCategory = new Category("Adventure", "description 2", true);

        Optional<Category> opCategory = Optional.of(category);

        when(repository.findById(category.getId())).thenReturn(opCategory);

        UpdateCategoryInputData input = new UpdateCategoryInputData();
        input.setName("Adventure");
        input.setDescription("description 2");
        input.setIsActive(true);

        category.update(input.getName(), input.getDescription(), input.getIsActive());

        doNothing().when(repository).update(category);

        useCase.execute(category.getId(), input);

        assertThat(category).isNotNull();
        assertThat(expectedCategory).isNotNull();
        assertThat(category.getName()).isEqualTo(expectedCategory.getName());
        assertThat(category.getDescription()).isEqualTo(expectedCategory.getDescription());
        assertThat(category.getIsActive()).isEqualTo(expectedCategory.getIsActive());
    }

    @Test
    public void throwNotFoundExceptionWhenIdIsWrong() {

        Category category = new Category("Action", "description", false);

        UpdateCategoryInputData input = new UpdateCategoryInputData();

        input.setName("Adventure");
        input.setDescription("description");
        input.setIsActive(true);

        assertThrows(NotFoundException.class, () -> useCase.execute(UUID.randomUUID(), input));
    }
}
