package com.fullcycle.CatalogoVideo.application.category;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import com.fullcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideo.application.usecase.category.findAll.FindAllCategorieUseCase;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class FindAllCategoryUseCaseTests {

    @InjectMocks
    private FindAllCategorieUseCase useCase;

    @Mock
    ICategoryRepository repository;

    @BeforeEach
    void initUsaCase() {
        useCase = new FindAllCategorieUseCase(repository);
    }

    @Test
    public void executeReturnsFindAllCategory() {
        List<Category> categories = Arrays.asList(
                new Category("Action", "description"),
                new Category("Suspence", "description"),
                new Category("Horror", "description"),
                new Category("Adventure", "description"),
                new Category("Comedy", "description"));

        when(repository.findAll()).thenReturn(categories);

        // doReturn(categories).when(repository).findAll();

        List<CategoryOutputData> actual = useCase.execute();

        repository.findAll();

        assertThat(categories).isNotNull().hasSize(5);
        // verify(repository, times(1)).findAll();
        assertThat(actual).isNotNull().hasSize(5);

    }
}
