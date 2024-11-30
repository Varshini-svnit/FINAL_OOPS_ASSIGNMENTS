package Lab2;

	import java.util.Scanner;

	class BankAccount {
	    private double balance;

	    public BankAccount(double initialBalance) {
	        balance = initialBalance;
	    }

	    public void deposit(double amount) {
	        balance += amount;
	        System.out.println("Deposited: " + amount);
	    }

	    public void withdraw(double amount) {
	        if (amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrawn: " + amount);
	        } else {
	            System.out.println("Insufficient funds.");
	        }
	    }

	    public void displayBalance() {
	        System.out.println("Current balance: " + balance);
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter initial balance: ");
	        double initialBalance = scanner.nextDouble();

	        BankAccount account = new BankAccount(initialBalance);

	        while (true) {
	            System.out.println("1. Deposit\n2. Withdraw\n3. Display Balance\n4. Exit");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();

	            if (choice == 1) {
	                System.out.print("Enter amount to deposit: ");
	                double amount = scanner.nextDouble();
	                account.deposit(amount);
	            } else if (choice == 2) {
	                System.out.print("Enter amount to withdraw: ");
	                double amount = scanner.nextDouble();
	                account.withdraw(amount);
	            } else if (choice == 3) {
	                account.displayBalance();
	            } else {
	                break;
	            }
	        }

	        scanner.close();
	    }
	}

}
