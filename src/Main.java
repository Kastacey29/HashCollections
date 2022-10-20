import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Product banana = new Product("банан", 35.6, 3.85);
        Product grapefruit = new Product("грейпфрут", 87.56, 0.54);
        Product mandarin = new Product("мандарин", 47.5, 0.89);
        Product mandarin1 = new Product("мандарин", 47.5, 0.89);

        Set<Product> products = new HashSet<>();
        addProduct(banana, products);
        addProduct(grapefruit, products);
        addProduct(mandarin, products);


        System.out.println(products);

        banana.setBought();
        System.out.println(products);
        removeProduct(grapefruit, products);
        System.out.println(products);

        Recipe recipe1 = new Recipe("Яичница", products, 0);
        Product egg = new Product("яйцо", 56.30, 0.09);
        Product solt = new Product("соль", 23.54, 0.01);
        Product ham = new Product("ветчина", 123.45, 0.23);


        recipe1.addProductInRecipe(egg);
        recipe1.addProductInRecipe(solt);
        recipe1.addProductInRecipe(ham);

        System.out.println(recipe1);

        Recipe recipe2 = new Recipe("Фруктовый салат", products, 0);
        Recipe recipe3 = new Recipe("Фруктовый салат", products, 0);

        Product yogurt = new Product("йогурт", 54.26, 0.17);


        recipe2.addProductInRecipe(banana);
        recipe2.addProductInRecipe(grapefruit);
        recipe2.addProductInRecipe(mandarin);
        recipe2.addProductInRecipe(yogurt);

        recipe3.addProductInRecipe(banana);
        recipe3.addProductInRecipe(grapefruit);
        recipe3.addProductInRecipe(mandarin);
        recipe3.addProductInRecipe(yogurt);

        System.out.println(recipe2);

        RecipeBook recipeBook1 = new RecipeBook();
        recipeBook1.addRecipe(recipe1);
        recipeBook1.addRecipe(recipe2);
        recipeBook1.addRecipe(recipe3);
        System.out.println(recipeBook1);

    }

    private static void addProduct(Product product, Set<Product> products) {
        if (products.contains(product)) {
            throw new RuntimeException("Такой продукт уже имеется в списке!");
        } else {
            products.add(product);
        }
    }

    private static void removeProduct(Product product, Set<Product> products) {
        products.remove(product);
    }
}