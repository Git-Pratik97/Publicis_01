package com.publicis.recipe.service;

import com.publicis.recipe.dao.RecipeRepository;
import com.publicis.recipe.entity.RecipeEntity;
import com.publicis.recipe.entity.RecipeResponse;
import com.publicis.recipe.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService{

    @Value("${external.api.recipes.url}")
    private String recipesApiUrl;

    private final RestTemplate restTemplate;
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RestTemplate restTemplate, RecipeRepository recipeRepository) {
        this.restTemplate = restTemplate;
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeEntity> loadRecipesFromApi() {
//        String apiUrl = "https://dummyjson.com/recipes";
        RecipeResponse response = restTemplate.getForObject(recipesApiUrl, RecipeResponse.class);

        if (response != null && response.getRecipes() != null) {
            List<RecipeEntity> recipes = response.getRecipes();
//            System.out.println("First Recipe : " + recipes.get(0).getId() + "  " + recipes.get(0).getCuisine());
                for (RecipeEntity recipe : recipes) {
                    if (recipe.getId() == null || recipe.getId().isBlank()) {
                            // Generate a fallback ID if missing
                            recipe.setId(UUID.randomUUID().toString());
                    }
                }

            return recipeRepository.saveAll(recipes);
        }

        return Collections.emptyList();
    }


    @Override
    public List<RecipeEntity> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public RecipeEntity getRecipeById(String id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with ID: " + id));
    }

    @Override
    public List<RecipeEntity> getAllRecipesWithName(String recipeName) {

        if (recipeName.length() > 3) {
            recipeName = recipeName.substring(0, 3);
        }
        return recipeRepository.findByRecipeStartsWithName(recipeName);
    }

    @Override
    public List<RecipeEntity> getAllRecipesWithCuisine(String cuisine) {
        if (cuisine.length() > 3) {
            cuisine = cuisine.substring(0, 3);
        }
        return recipeRepository.findByRecipeStartsWithCuisine(cuisine);
    }
}
