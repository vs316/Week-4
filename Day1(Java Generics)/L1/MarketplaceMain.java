abstract class ProductCategory { }

class BookCategory extends ProductCategory { }
class ClothingCategory extends ProductCategory { }
class GadgetCategory extends ProductCategory { }

class Product<T extends ProductCategory> {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Marketplace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(newPrice);
    }
}
public class MarketplaceMain {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 499.99);
        Product<GadgetCategory> gadget = new Product<>("Smart Watch", 999.99);

        System.out.println("Before discount:");
        System.out.println("Book Price: " + book.getPrice());
        System.out.println("Gadget Price: " + gadget.getPrice());

        Marketplace.applyDiscount(book, 10);
        Marketplace.applyDiscount(gadget, 15);

        System.out.println("\nAfter discount:");
        System.out.println("Book Price: " + book.getPrice());
        System.out.println("Gadget Price: " + gadget.getPrice());
    }
}