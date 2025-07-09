package ShoppingCart_App;

import java.util.Scanner;

/**
 * Main logic controller for the shopping cart program.
 */
@AppInfo(
        author = "CodeByMed",
        version = "1.0",
        description = "A console-based shopping cart system using modern Java."
)
public class ShoppingCart_Program implements Runnable {

    private final Cart cart = new Cart();

    @Override
    public void run() {
        printAppMetadata();

        System.out.println("Welcome to the Shopping Cart App!");
        Scanner scanner = new Scanner(System.in);

        // Sample Products
        Product apple = new Product(1, "Apple", 0.99, Category.FOOD);
        Product jeans = new Product(2, "Jeans", 39.99, Category.CLOTHING);
        Product laptop = new Product(3, "Laptop", 899.99, Category.ELECTRONICS);

        cart.addProduct(apple, 3);
        cart.addProduct(jeans, 1);
        cart.addProduct(laptop, 1);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View Cart");
            System.out.println("2. Remove Item");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> cart.viewCart();
                case "2" -> {
                    System.out.print("Enter Product ID to remove: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    cart.removeProduct(id);
                }
                case "3" -> {
                    System.out.printf("Total Price: $%.2f%n", cart.calculateTotal());
                }
                case "4" -> {
                    System.out.println("Thank you for using the Shopping Cart App!");
                    return;
                }
                default -> System.out.println("Invalid input.");
            }
        }
    }

    /**
     * Uses reflection to print AppInfo annotation metadata.
     */
    private void printAppMetadata() {
        AppInfo info = this.getClass().getAnnotation(AppInfo.class);
        if (info != null) {
            System.out.println("=== App Info ===");
            System.out.printf("Author      : %s%n", info.author());
            System.out.printf("Version     : %s%n", info.version());
            System.out.printf("Description : %s%n", info.description());
            System.out.println("================\n");
        }
    }
}