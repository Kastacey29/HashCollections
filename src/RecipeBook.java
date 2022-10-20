import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RecipeBook {
    private Set<Recipe> recipes;

    public RecipeBook() {
        this.recipes = new HashSet<>();
    }

    public void addRecipe(Recipe recipe) {
        if (recipes.contains(recipe)) {
            throw new RuntimeException("Такой рецепт уже существует!");
        } else {
            recipes.add(recipe);
        }
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeBook)) return false;
        RecipeBook that = (RecipeBook) o;
        return Objects.equals(recipes, that.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipes);
    }

    @Override
    public String toString() {
        return "RecipeBook{" +
                "recipes=" + recipes +
                '}';
    }
}
