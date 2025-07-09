package ShoppingCart_App;

/**
 * Record representing a product in the shop.
 * Implements Identifiable for consistent ID access.
 *
 * @param id Product ID
 * @param name Product name
 * @param price Product price
 * @param category Product category
 */
public record Product(int id, String name, double price, Category category) implements Identifiable {

    public Product {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative.");
    }

    @Override
    public int getId() {
        return id;
    }
}