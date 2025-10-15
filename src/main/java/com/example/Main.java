package com.example;

import java.util.Scanner;

public class Main {
    static void main() {
        PasswordValidator passwordValidator = new PasswordValidator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Password Utility ===");
            System.out.println("1. Generate secure password");
            System.out.println("2. Validate existing password");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter desired length (8–36): ");
                    String line = scanner.nextLine().trim();
                    try {
                        int len = Integer.parseInt(line);
                        if (len < 8 || len > 36) {
                            System.out.println("❌ Length must be between 8 and 36.");
                            break;
                        }
                        String pwd = passwordValidator.generateSecurePassword(len, PasswordValidator.SPECIALCHARS);
                        System.out.println("\n✅ Generated password: " + pwd);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Please enter a valid number.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                }

                case "2" -> {
                    System.out.print("Enter password to validate: ");
                    String input = scanner.nextLine();
                    var result = passwordValidator.validate(input, PasswordValidator.SPECIALCHARS);
                    if (result.valid()) {
                        System.out.println("\n✅ Password is valid!");
                    } else {
                        System.out.println("\n❌ Invalid password. Reasons:");
                        result.reasons().forEach(r -> System.out.println(" - " + r));
                    }
                }

                case "0" -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
