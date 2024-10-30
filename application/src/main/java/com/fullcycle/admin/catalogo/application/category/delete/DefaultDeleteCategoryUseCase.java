package com.fullcycle.admin.catalogo.application.category.delete;

import com.fullcycle.admin.catalogo.domain.category.CategoryGateway;
import com.fullcycle.admin.catalogo.domain.category.CategoryID;

import java.util.Objects;

public class DefaultDeleteCategoryUseCase extends DeleteCategoryUseCase{

    private final CategoryGateway categoryGateway;

    public DefaultDeleteCategoryUseCase(final CategoryGateway aCategoryGateway) {
        this.categoryGateway = Objects.requireNonNull(aCategoryGateway);
    }

    @Override
    public void execute(final String anInput) {
        this.categoryGateway.deleteById(CategoryID.from(anInput));
    }
}
