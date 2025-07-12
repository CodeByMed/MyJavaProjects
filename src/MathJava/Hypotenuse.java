package MathJava;

import java.util.Scanner;

public class Hypotenuse {
    public static void main(String[] args) {

        // HYPOTENUSE c = Math.sqrt(a² + b²)

        Scanner scanner = new Scanner(System.in);

        double a;
        double b;
        double c;

        System.out.print("Enter the length of side a: ");
        a = scanner.nextDouble();

        System.out.print("Enter the length of side b: ");
        b = scanner.nextDouble();

        c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        System.out.printf("The Hypotenuse c is: %.2fcm\n", c);

        scanner.close();
    }
}
