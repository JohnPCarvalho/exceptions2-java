package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ENTER THE ACCOUNT DATA:");
		System.out.println("Number: ");
		Integer number = sc.nextInt();
		System.out.println("Holder: ");
		String holder = sc.next();
		System.out.println("Initial Balance: ");
		Double initialBalance = sc.nextDouble();
		System.out.println("Withdraw Limit: ");
		Double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(number, holder, initialBalance, withdrawLimit);
		
		try {
			System.out.println("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
			account.withdraw(amount);
		} 
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println(account.getBalance());
		}
	
	}

}
