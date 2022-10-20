import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Recipe {
    private final String name;
    private final Set<Product> products;
    private double totalCost;

    public Recipe(String name, Set<Product> products, double totalCost) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Введите название!");
        } else {
            this.name = name;
        }
        this.products = new HashSet<>();
        this.totalCost = 0;
    }

    public String getName() {
        return name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void addProductInRecipe(Product product) {
        if (products.contains(product)) {
            throw new IllegalArgumentException("Такой продукт уже содержится в рецепте!");
        }
        products.add(product);
        totalCost += product.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return Double.compare(recipe.totalCost, totalCost) == 0 && name.equals(recipe.name) && products.equals(recipe.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, products, totalCost);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", products=" + products +
                String.format(", totalCost= %.2f", totalCost) +
                '}';
    }
}
