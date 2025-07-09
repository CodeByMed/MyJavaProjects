package ShoppingCart_App;

import java.util.*;

/**
 * Class managing cart operations like add, remove, view, and calculate total.
 */
public class Cart {

    private final Map<Integer, CartItem> items = new HashMap<>();

    /**
     * Adds a product with the specified quantity.
     */
    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) throw new CartException("Quantity must be positive.");

        items.merge(product.id(), new CartItem(product, quantity),
                (oldItem, newItem) ->
                        new CartItem(oldItem.product(), oldItem.quantity() + newItem.quantity()));
    }

    /**
     * Removes a product by its ID.
     */
    public void removeProduct(int productId) {
        if (!items.containsKey(productId)) {
            System.out.println("Product not found in cart.");
            return;
        }
        items.remove(productId);
        System.out.println("Product removed.");
    }

    /**
     * Displays all items in the cart.
     */
    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("Your cart:");
        for (CartItem item : items.values()) {
            Product p = item.product();
            System.out.printf("- %s (%s): $%.2f x %d = $%.2f%n",
                    p.name(), p.category(), p.price(), item.quantity(), item.totalPrice());
        }
    }

    /**
     * Calculates the total cost of all items in the cart.
     *
     * @return total price
     */
    public double calculateTotal() {
        return items.values().stream()
                .mapToDouble(CartItem::totalPrice)
                .sum();
    }
}
