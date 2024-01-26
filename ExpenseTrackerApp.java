import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
	String date;
	String description;
	double earnings;
	double expenses;
	
	public Transaction(String date, String description, double earning, double expenses) {
		this.date = date;
		this.description = description;
		this.earnings = earnings;
		this.expenses = expenses;
	}
}

public class ExpenseTrackerApp {
	public static void main(String[] args) {
		ArrayList<Transaction> transactions = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Enter transaction details (date, description, earnings, expenses):");
			System.out.print("Date (dd-mm-yyyy)");
			String date = scanner.next();
			
			if (date.equals("exit")) {
				break;
			}
			
			scanner.nextLine();
			
			System.out.print("Description: ");
			String description = scanner.nextLine();
			
			System.out.print("Earnings (rupe): ");
			double earnings = scanner.nextDouble();
			
			System.out.print("Expenses (rupe): ");
			double expenses = scanner.nextDouble();
			
			transactions.add(new Transaction(date, description, earnings, expenses));
			
		}
		
		// Print Black Statement
		System.out.println("\nBank Statement");
		System.out.println("..........................................");
		System.out.printf("%-15s %-20s %-15s %-15s\n", "Date", "Description", "Earnings (rupe)", "Expenses (rupe)");
		System.out.println("..........................................");
		
		for (Transaction transaction : transactions) {
			System.out.printf("%-15s %-20s %-15.2f %-15.2f\n",
					transaction.date, transaction.description, transaction.earnings, transaction.expenses);
		}
		
		double totalEarnings = transactions.stream().mapToDouble(t -> t.earnings).sum();
		double totalExpenses = transactions.stream().mapToDouble(t -> t.expenses).sum();
		double netIncome = totalEarnings - totalExpenses;
		
		System.out.println("...........................");
		System.out.printf("Total earning: rupe%.2f\n", totalEarnings);
		System.out.printf("Total expenses: rupe%.2f\n", totalExpenses);
		System.out.println("...........................");
		
		scanner.close();
		
	}
}

/*
Enter transaction details (date, description, earnings, expenses):
Date (dd-mm-yyyy)
26-01-2024
Description: party with friends
Earnings (rupe): 1000
Expenses (rupe): 1000
Enter transaction details (date, description, earnings, expenses):
Date (dd-mm-yyyy)exit

Bank Statement
..........................................
Date            Description          Earnings (rupe) Expenses (rupe)
..........................................
26-01-2024      party with friends   0.00            1000.00        
...........................
Total earning: rupe0.00
Total expenses: rupe1000.00
...........................

*/
