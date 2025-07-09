package ShoppingCart_App;

/**
 * Custom exception class for cart-related errors.
 */
public class CartException extends RuntimeException {
  public CartException(String message) {
    super(message);
  }
}
