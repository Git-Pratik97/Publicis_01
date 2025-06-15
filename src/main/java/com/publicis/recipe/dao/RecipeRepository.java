package com.publicis.recipe.dao;

import com.publicis.recipe.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<RecipeEntity, String> {

    @Query(value = "SELECT * FROM recipe_entity WHERE LEFT(name, 3) = :prefix", nativeQuery = true)
    List<RecipeEntity> findByRecipeStartsWithName(@Param("prefix") String prefix);

    @Query(value = "SELECT * FROM recipe_entity WHERE LEFT(cuisine, 3) = :prefix", nativeQuery = true)
    List<RecipeEntity> findByRecipeStartsWithCuisine(@Param("prefix") String cuisine);
}
