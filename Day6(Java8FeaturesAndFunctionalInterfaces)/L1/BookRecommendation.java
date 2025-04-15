package java8Features;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java8Features.Book.filterScienceFictionBooks;
import static java8Features.Book.transformToRecommendations;

class Book {
    private String title;
    private String author;
    private String genre;
    private double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return String.format("Book { title: '%s', author: '%s', genre: '%s', rating: %.2f }",
                title, author, genre, rating);
    }

    public static List<Book> filterScienceFictionBooks(List<Book> books) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase("Science Fiction") && book.getRating() > 4.0)
                .toList();
    }

    public static List<BookRecommendation> transformToRecommendations(List<Book> books) {
        return books.stream()
                .map(book -> new BookRecommendation(book.getTitle(), book.getRating()))
                .toList();
    }
}

public class BookRecommendation {
    private String title;
    private double rating;

    public String getTitle() {
        return title;
    }
    public double getRating() {
        return rating;
    }
    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("BookRecommendation { title: '%s', rating: %.2f }", title, rating);
    }
    public static List<BookRecommendation> sortByRatingDescending(List<BookRecommendation> recommendations) {
        return recommendations.stream()
                .sorted(Comparator.comparingDouble(BookRecommendation::getRating).reversed())
                .toList();
    }
    public static List<List<BookRecommendation>> paginateRecommendations(List<BookRecommendation> recommendations) {
        int pageSize = 5;
        List<List<BookRecommendation>> pages = new ArrayList<>();
        for (int i = 0; i < recommendations.size(); i += pageSize) {
            pages.add(recommendations.subList(i, Math.min(i + pageSize, recommendations.size())));
        }
        return pages;
    }
        public static void main(String[] args) {
            List<Book> books = List.of(
                    new Book("Dune", "Frank Herbert", "Science Fiction", 4.6),
                    new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.4),
                    new Book("The Martian", "Andy Weir", "Science Fiction", 4.7),
                    new Book("1984", "George Orwell", "Dystopian", 4.2),
                    new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.1),
                    new Book("Brave New World", "Aldous Huxley", "Dystopian", 3.8),
                    new Book("Neuromancer", "William Gibson", "Science Fiction", 3.9),
                    new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.8),
                    new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.5),
                    new Book("I, Robot", "Isaac Asimov", "Science Fiction", 4.3)
            );

            // Step 1: Filter
            List<Book> filteredBooks = filterScienceFictionBooks(books);

            // Step 2: Transform
            List<BookRecommendation> recommendations = transformToRecommendations(filteredBooks);

            // Step 3: Sort
            List<BookRecommendation> sortedRecommendations = sortByRatingDescending(recommendations);

            // Step 4: Paginate
            List<List<BookRecommendation>> paginatedRecommendations = paginateRecommendations(sortedRecommendations);

            // Display Results
            System.out.println("Paginated Recommendations:");
            for (int i = 0; i < paginatedRecommendations.size(); i++) {
                System.out.println("Page " + (i + 1) + ":");
                paginatedRecommendations.get(i).forEach(System.out::println);
            }
        }
    }
