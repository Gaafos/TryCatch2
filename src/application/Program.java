package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.ValueFailure;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String name = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdraw = sc.nextDouble();

			Account acc = new Account(number, name, balance, withdraw);

			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();

			acc.withdraw(amount);
			System.out.printf("New balance: %.2f", acc.getBalance());
		}

		catch (ValueFailure e) {
			System.out.println("Error: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Error: invalid character");
		} catch (RuntimeException e) {
			System.out.println("Error: Unexpected error");
		}

		sc.close();

	}

}
