package MathJava;

import java.util.Scanner;

public class Circumference {
    public static void main(String[] args) {

        // Circumference = 2 * Math.PI * radius
        // area = Math.PI * Math.pow(radius, 2)
        // volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3)

        Scanner scanner = new Scanner(System.in);

        double radius;
        double circumference;
        double area;
        double volume;

        System.out.print("Enter the radius: ");
        radius = scanner.nextDouble();

        circumference = 2 * Math.PI * radius;
        area = Math.PI * Math.pow(radius, 2);
        volume = (3.0 / 4.0) * Math.PI * Math.pow(radius, 3);

        System.out.printf("The circumference is: %.2fcm\n", circumference);
        System.out.printf("The area is: %.2fcm²\n", area);
        System.out.printf("The volume is: %.2fcm³\n", volume);

        scanner.close();
    }
}