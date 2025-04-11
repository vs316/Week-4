package JavaCollections.MapInterface;

public class ShoppingCartDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Create some products
        Product laptop = new Product("P001", "Laptop", 999.99, "Electronics");
        Product phone = new Product("P002", "Smartphone", 599.99, "Electronics");
        Product book = new Product("P003", "Java Programming", 49.99, "Books");
        Product headphones = new Product("P004", "Wireless Headphones", 199.99, "Electronics");
        Product mouse = new Product("P005", "Gaming Mouse", 79.99, "Electronics");

        // Add items to cart
        System.out.println("Adding items to cart...");
        cart.addItem(laptop, 1);
        cart.addItem(phone, 2);
        cart.addItem(book, 3);
        cart.addItem(headphones, 1);
        cart.addItem(mouse, 1);

        // Display initial cart state
        cart.displayCart();

        // Update quantity of an item
        System.out.println("\nUpdating quantity of Java Programming book to 5...");
        cart.updateQuantity(book, 5);
        cart.displayCart();

        // Remove an item
        System.out.println("\nRemoving Smartphone from cart...");
        cart.removeItem(phone);
        cart.displayCart();

        // Add more of an existing item
        System.out.println("\nAdding one more Wireless Headphones...");
        cart.addItem(headphones, 1);
        cart.displayCart();

        // Clear the cart
        System.out.println("\nClearing the cart...");
        cart.clearCart();
        cart.displayCart();
    }
}