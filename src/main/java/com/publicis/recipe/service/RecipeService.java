package com.publicis.recipe.service;

import com.publicis.recipe.entity.RecipeEntity;

import java.util.List;

public interface RecipeService {

    List<RecipeEntity> loadRecipesFromApi();
    List<RecipeEntity> getAllRecipes();
    RecipeEntity getRecipeById(String id);

    List<RecipeEntity> getAllRecipesWithName(String recipeName);

    List<RecipeEntity> getAllRecipesWithCuisine(String cuisine);
}
