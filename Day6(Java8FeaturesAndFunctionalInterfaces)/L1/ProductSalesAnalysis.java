package java8Features;

import java.util.*;
import java.util.stream.Collectors;

class ProductSales {
    private String productId;
    private double totalRevenue;

    public ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    public String getProductId() {
        return productId;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    @Override
    public String toString() {
        return "ProductSales{" +
                "productId='" + productId + '\'' +
                ", totalRevenue=" + totalRevenue +
                '}';
    }
}

class Sale {
    String productId;
    int quantity;
    double price;

    public Sale() {}

    public Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public static List<Sale> filterSales(List<Sale> sales) {
        return sales.stream()
                .filter(sale -> sale.getQuantity() > 10)
                .toList();
    }

    // Transform sales to ProductSales objects
    public static List<ProductSales> transformToProductSales(List<Sale> sales) {
        return sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::getProductId,
                        Collectors.summingDouble(sale -> sale.getQuantity() * sale.getPrice())
                ))
                .entrySet()
                .stream()
                .map(entry -> new ProductSales(entry.getKey(), entry.getValue()))
                .toList();
    }

    // Sort ProductSales by revenue in descending order and return new sorted list
    public static List<ProductSales> sortByRevenue(List<ProductSales> productSales) {
        List<ProductSales> sortedList = new ArrayList<>(productSales);
        sortedList.sort((p1, p2) -> Double.compare(p2.getTotalRevenue(), p1.getTotalRevenue()));
        return sortedList;
    }

    // Get top N products by revenue
    public static List<ProductSales> getTopNProducts(List<ProductSales> productSales, int n) {
        return productSales.stream()
                .limit(n)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("Sale { productId: '%s', quantity: %d, price: %.2f }", productId, quantity, price);
    }
}

public class ProductSalesAnalysis {
    public static void main(String[] args) {
        // Create test data
        List<Sale> sales = new ArrayList<>(Arrays.asList(
                new Sale("P1", 15, 100),
                new Sale("P2", 5, 200),
                new Sale("P1", 20, 100),
                new Sale("P3", 12, 150),
                new Sale("P4", 8, 300),
                new Sale("P5", 25, 75),
                new Sale("P2", 11, 200)
        ));

        // Step 1: Filter sales with quantity > 10
        List<Sale> filteredSales = Sale.filterSales(sales);
        System.out.println("Filtered Sales (Quantity > 10):");
        filteredSales.forEach(System.out::println);

        // Step 2: Transform to ProductSales
        List<ProductSales> productSales = Sale.transformToProductSales(filteredSales);
        System.out.println("\nTransformed to ProductSales:");
        productSales.forEach(System.out::println);

        // Step 3: Sort by revenue
        List<ProductSales> sortedProductSales = Sale.sortByRevenue(productSales);
        System.out.println("\nSorted by Revenue (Descending):");
        sortedProductSales.forEach(System.out::println);

        // Step 4: Get top 5 products
        List<ProductSales> topProducts = Sale.getTopNProducts(sortedProductSales, 5);
        System.out.println("\nTop 5 Products by Revenue:");
        topProducts.forEach(System.out::println);
    }
}
