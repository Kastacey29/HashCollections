import java.util.*;

public class Recipe {
    private final String name;
    private final Map<Product, Integer> products;
    private double totalCost;

    public Recipe(String name, Map<Product, Integer> products, double totalCost) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Введите название!");
        } else {
            this.name = name;
        }
        this.products = new HashMap<>();
        this.totalCost = 0;
    }

    public String getName() {
        return name;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void addProductInRecipe(Product product, Map<Product, Integer> products, Integer quantity) {
        if (products.containsKey(product)) {
            throw new IllegalArgumentException("Такой продукт уже содержится в рецепте!");
        }
        products.put(product, quantity);
        if (quantity == null || quantity < 1) {
            throw new RuntimeException("Установите количество!");
        }
        totalCost = totalCost + (product.getPrice() * quantity);
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
