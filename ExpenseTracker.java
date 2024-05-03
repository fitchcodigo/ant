import java.io.FileWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;

class Expense {
    String description;
    double amount;
    String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }
}

public class ExpenseTracker {
    public static void main(String[] args) {
        List<Expense> expenses = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("klk compraste buen irresponsable (pon 'baraja' pa sali): ");
            String description = scanner.nextLine();
            if (description.equalsIgnoreCase("baraja")) {

                System.out.print("ya dame banda. ");
                break;
            }

            System.out.print("y cuanto tu gastaste en esa polqueria");
            double amount = Double.parseDouble(scanner.nextLine());

            System.out.print("categorizalo ");
            String category = scanner.nextLine();

            expenses.add(new Expense(description, amount, category));
        }

        System.out.println("gastos:");
        for (Expense expense : expenses) {
            System.out.printf("%s - categoria: %s - cualto: %.2f%n", expense.description, expense.category, expense.amount);
        }

        double totalExpenses = expenses.stream().mapToDouble(expense -> expense.amount).sum();
        System.out.printf("Total: %.2f%n", totalExpenses);

        try (PrintWriter writer = new PrintWriter(new FileWriter("expenses.txt"))) {
            for (Expense expense : expenses) {
                writer.printf("%s,%s,%.2f%n", expense.description, expense.category, expense.amount);
            }
        } catch (IOException e) {
            System.out.println("mira lo que hiciste pp " + e.getMessage());
        }

        scanner.close();
    }
}