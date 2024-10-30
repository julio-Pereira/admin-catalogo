package com.fullcycle.admin.catalogo.application.category.retrieve.get;

import com.fullcycle.admin.catalogo.domain.category.CategoryGateway;
import com.fullcycle.admin.catalogo.domain.category.CategoryID;
import com.fullcycle.admin.catalogo.domain.exceptions.DomainException;
import com.fullcycle.admin.catalogo.domain.validation.Error;

import java.util.Objects;
import java.util.function.Supplier;

public class DefaultGetCategoryByIdUseCase extends GetCategoryByIdUseCase {


    private final CategoryGateway gateway;

    public DefaultGetCategoryByIdUseCase(CategoryGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway);
    }

    @Override
    public CategoryOutput execute(final String anInput) {
        final var anCategoryId = CategoryID.from(anInput);
        return this.gateway.findById(anCategoryId)
                .map(CategoryOutput::from)
                .orElseThrow(notFound(anCategoryId));

    }

    private Supplier<DomainException> notFound(final CategoryID anCategoryId) {
        return () -> DomainException.with(
                new Error("Category with ID %s was not found".formatted(anCategoryId.getValue()))
        );
    }
}
