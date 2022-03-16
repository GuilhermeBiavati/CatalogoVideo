package com.fullcycle.CatalogoVideo.application.usecase.category.findAll;

import java.util.List;

import com.fullcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;

public interface IFindAllCategorieUseCase {
    List<CategoryOutputData> execute();
}
