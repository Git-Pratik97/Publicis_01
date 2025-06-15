package com.publicis.recipe.controller;

import com.publicis.recipe.entity.RecipeEntity;
import com.publicis.recipe.service.RecipeService;
import com.publicis.recipe.service.RecipeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public RecipeEntity getRecipeById(@PathVariable String id) {
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
