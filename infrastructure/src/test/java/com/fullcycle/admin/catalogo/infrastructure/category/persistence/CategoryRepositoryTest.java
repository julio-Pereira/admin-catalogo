package com.fullcycle.admin.catalogo.infrastructure.category.persistence;

import com.fullcycle.admin.catalogo.domain.category.Category;
import com.fullcycle.admin.catalogo.MySQLGatewayTest;
import org.hibernate.PropertyValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

@MySQLGatewayTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void givenAnInvvalidNullName_whenCallsSave_shouldReturnErro() {
        final var expectedPropertyName = "name";
        final var expectecMessage = "not-null property references a null or transient value : com.fullcycle.admin.catalogo.infrastructure.category.persistence.CategoryJpaEntity.name";
        final var aCategory = Category.newCategory("Filmes", "A Categoria mais assistida", true);

        final var anEntity = CategoryJpaEntity.from(aCategory);

        anEntity.setName(null);

        final var actualException =
                Assertions.assertThrows(DataIntegrityViolationException.class, () -> categoryRepository.save(anEntity));

        final var actualCause =
                Assertions.assertInstanceOf(PropertyValueException.class, actualException.getCause());

        Assertions.assertEquals(expectedPropertyName, actualCause.getPropertyName());
        Assertions.assertEquals(expectecMessage, actualCause.getMessage());
    }

    @Test
    public void givenAnInvvalidNullCreatedAt_whenCallsSave_shouldReturnErro() {
        final var expectedPropertyName = "createdAt";
        final var expectecMessage = "not-null property references a null or transient value : com.fullcycle.admin.catalogo.infrastructure.category.persistence.CategoryJpaEntity.createdAt";
        final var aCategory = Category.newCategory("Filmes", "A Categoria mais assistida", true);

        final var anEntity = CategoryJpaEntity.from(aCategory);

        anEntity.setCreatedAt(null);

        final var actualException =
                Assertions.assertThrows(DataIntegrityViolationException.class, () -> categoryRepository.save(anEntity));

        final var actualCause =
                Assertions.assertInstanceOf(PropertyValueException.class, actualException.getCause());

        Assertions.assertEquals(expectedPropertyName, actualCause.getPropertyName());
        Assertions.assertEquals(expectecMessage, actualCause.getMessage());
    }

    @Test
    public void givenAnInvvalidNullupdatedAt_whenCallsSave_shouldReturnErro() {
        final var expectedPropertyName = "updatedAt";
        final var expectecMessage = "not-null property references a null or transient value : com.fullcycle.admin.catalogo.infrastructure.category.persistence.CategoryJpaEntity.updatedAt";
        final var aCategory = Category.newCategory("Filmes", "A Categoria mais assistida", true);

        final var anEntity = CategoryJpaEntity.from(aCategory);

        anEntity.setUpdatedAt(null);

        final var actualException =
                Assertions.assertThrows(DataIntegrityViolationException.class, () -> categoryRepository.save(anEntity));

        final var actualCause =
                Assertions.assertInstanceOf(PropertyValueException.class, actualException.getCause());

        Assertions.assertEquals(expectedPropertyName, actualCause.getPropertyName());
        Assertions.assertEquals(expectecMessage, actualCause.getMessage());
    }
}
