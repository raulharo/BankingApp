package App;
import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		Scanner accIn = new Scanner(System.in);
		System.out.print("Welcome! Please enter your name and ID: ");
		BankAccount newAcc = new BankAccount(accIn.nextLine(), accIn.nextLine());
		newAcc.showMenu();
		accIn.close();
	}

}


class BankAccount {
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	BankAccount(String cname, String cid){
		customerName = cname;
		customerId = cid;
	}
	
	public int checkBalance() {
		return balance;
	}
	
	void deposit(int amount) {
		if(amount != 0) {
			balance += amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount != 0) {
			if (amount != 0) {
				balance -= amount;
				previousTransaction = -amount;
			}
		}
	}
	
	void getPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.print("Deposited: " + previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.print("Withdrew: " + Math.abs(previousTransaction));
		}
		else {
			System.out.print("No transaction recorded");
		}
	}
	
	void showMenu() {
		char option;
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Welcome " + customerName + "!");
		System.out.println("Your ID is " + customerId + ".");
		System.out.println("");
		System.out.println("A. Check balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. View previous transaction");
		System.out.println("E. Exit");
		
		do {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.print("Enter an option: ");
			option = userInput.next().charAt(0);
			System.out.println("");
			
			switch(option) {
			case 'A':
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.print("Your balance is: $" + checkBalance() + ".");
				System.out.println("");
				break;
			case 'B':
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.print("Enter your deposit amount: $");
				deposit(userInput.nextInt());
				System.out.println("");
				break;
			case 'C':
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.print("Enter your withdrawl amount: $");
				withdraw(userInput.nextInt());
				System.out.println("");
				break;
			case 'D':
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				getPreviousTransaction();
				System.out.println("");
				break;
			case 'E':
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				break;
			default:
				System.out.println("Invalid option! Please enter a vaild option");
				System.out.println("");
				break;
			}
		}while(option != 'E');
		
		System.out.println("Thank you for banking with us!");
		userInput.close();
			
	}
}