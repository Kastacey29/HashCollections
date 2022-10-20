import java.util.Objects;

public class Product {
    private final String name;
    private double price;
    private double weight;
    private boolean isBought;

    public Product(String name, double price, double weight) {
        if (name == null || price == 0 || weight == 0) {
            throw new RuntimeException("Заполните карточку товара полностью!");
        } else {
            this.name = name;
            this.price = price;
            this.weight = weight;
        }

    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought() {
        this.isBought = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Double.compare(product.weight, weight) == 0 && isBought == product.isBought && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, weight, isBought);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", isBought=" + isBought +
                '}';
    }
}
