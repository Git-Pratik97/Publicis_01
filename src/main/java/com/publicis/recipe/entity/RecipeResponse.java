package com.publicis.recipe.entity;

import lombok.Data;

import java.util.List;

@Data
public class RecipeResponse {

        private List<RecipeEntity> recipes;
        private int total;
        private int skip;
        private int limit;

        public List<RecipeEntity> getRecipes() {
                return recipes;
        }

        public void setRecipes(List<RecipeEntity> recipes) {
                this.recipes = recipes;
        }

        public int getTotal() {
                return total;
        }

        public void setTotal(int total) {
                this.total = total;
        }

        public int getSkip() {
                return skip;
        }

        public void setSkip(int skip) {
                this.skip = skip;
        }

        public int getLimit() {
                return limit;
        }

        public void setLimit(int limit) {
                this.limit = limit;
        }
}
