package com.publicis.recipe.controller;

import com.publicis.recipe.entity.RecipeEntity;
import com.publicis.recipe.exception.ResourceNotFoundException;
import com.publicis.recipe.service.RecipeService;
import com.publicis.recipe.service.RecipeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Main entry point for the Recipe Spring Boot application.
 * Enables caching and bootstraps the application context.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeServiceImpl recipeService;

    public RecipeController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/load")
    public List<RecipeEntity> loadRecipes() {
        return recipeService.loadRecipesFromApi();
    }

    @GetMapping
    public List<RecipeEntity> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public RecipeEntity getRecipeById(@PathVariable String id) throws ResourceNotFoundException {
        return recipeService.getRecipeById(id);
    }

    @GetMapping("/recipename")
    public List<RecipeEntity> getRecipeByRecipe(@RequestParam String recipeName){
        return recipeService.getAllRecipesWithName(recipeName);
    }

    @GetMapping("/cuisine")
    public List<RecipeEntity> getRecipeByCuisine(@RequestParam String cuisine){
        return recipeService.getAllRecipesWithCuisine(cuisine);
    }
}
