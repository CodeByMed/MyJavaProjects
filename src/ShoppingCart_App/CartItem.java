package ShoppingCart_App;

/**
 * Represents an item in the shopping cart.
 *
 * @param product The product being purchased.
 * @param quantity Quantity of the product.
 */
public record CartItem(Product product, int quantity) {
    public double totalPrice() {
        return product.price() * quantity;
    }
}
