package JavaCollections.MapInterface;

import java.util.*;

public class ShoppingCart {
    // HashMap to store product prices for quick lookup
    private Map<Product, Integer> cartItems;

    // LinkedHashMap to maintain the order of items added
    private Map<Product, Integer> itemsByOrder;

    // TreeMap to display items sorted by price
    private TreeMap<Double, List<Product>> itemsByPrice;

    public ShoppingCart() {
        this.cartItems = new HashMap<>();
        this.itemsByOrder = new LinkedHashMap<>();
        this.itemsByPrice = new TreeMap<>();
    }

    public void addItem(Product product, int quantity) {
        // Update or add quantity in HashMap
        cartItems.merge(product, quantity, Integer::sum);

        // Update or add quantity in LinkedHashMap
        itemsByOrder.merge(product, quantity, Integer::sum);

        // Update TreeMap
        updatePriceSortedItems(product);
    }

    public void removeItem(Product product) {
        // Remove from all maps
        cartItems.remove(product);
        itemsByOrder.remove(product);

        // Remove from price-sorted map
        itemsByPrice.values().forEach(products -> products.remove(product));
        // Clean up empty lists
        itemsByPrice.values().removeIf(List::isEmpty);
    }

    private void updatePriceSortedItems(Product product) {
        // Remove product from all price lists first
        itemsByPrice.values().forEach(products -> products.remove(product));

        // Add product to appropriate price list
        itemsByPrice.computeIfAbsent(product.getPrice(), k -> new ArrayList<>())
                .add(product);

        // Clean up empty lists
        itemsByPrice.values().removeIf(List::isEmpty);
    }

    public void updateQuantity(Product product, int newQuantity) {
        if (newQuantity <= 0) {
            removeItem(product);
        } else {
            cartItems.put(product, newQuantity);
            itemsByOrder.put(product, newQuantity);
            updatePriceSortedItems(product);
        }
    }

    public double getTotalPrice() {
        return cartItems.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public Map<Product, Integer> getCartItems() {
        return new HashMap<>(cartItems);
    }

    public Map<Product, Integer> getItemsByOrder() {
        return new LinkedHashMap<>(itemsByOrder);
    }

    public Map<Double, List<Product>> getItemsByPrice() {
        return new TreeMap<>(itemsByPrice);
    }

    public int getQuantity(Product product) {
        return cartItems.getOrDefault(product, 0);
    }

    public void displayCart() {
        System.out.println("\nShopping Cart Contents:");
        System.out.println("----------------------");

        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        System.out.println("\nItems by Addition Order:");
        itemsByOrder.forEach((product, quantity) -> System.out.printf("%s - Quantity: %d, Total: $%.2f%n",
                product, quantity, product.getPrice() * quantity));

        System.out.println("\nItems Sorted by Price:");
        itemsByPrice.forEach(
                (price, products) -> products.forEach(product -> System.out.printf("%s - Quantity: %d, Total: $%.2f%n",
                        product, getQuantity(product), price * getQuantity(product))));

        System.out.printf("\nTotal Cart Value: $%.2f%n", getTotalPrice());
    }

    public void clearCart() {
        cartItems.clear();
        itemsByOrder.clear();
        itemsByPrice.clear();
    }
}