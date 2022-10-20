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
        addProduct(mandarin1, products);

        System.out.println(products);

        banana.setBought();
        System.out.println(products);
        removeProduct(grapefruit, products);
        System.out.println(products);

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