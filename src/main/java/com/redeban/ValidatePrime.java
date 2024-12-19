package com.redeban;

import java.util.Scanner;

public class ValidatePrime {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter a number: ");
			
			String number = scanner.next();
			
			if (!validateNumber(number)) {
				System.out.println("The data entered is not numeric");
				return;
			}
			
			if (validateNumber(Integer.valueOf(number))) {
				System.out.println("Is prime number");
			} else {
				System.out.println("It is not a prime number");
			}
		}
	}

	private static boolean validateNumber(int number) {
		if (number <= 1) {
			return false;
		}

		for (int i = 2; i < number; i++) {
			double rest = number % i;
			
			System.out.println(number + "%" + i + " = " + rest);
			
			if (rest == 0) {
				return false;
			}
		}

		return true;
	}
	
	private static boolean validateNumber(String number) {
		try {
			Integer.valueOf(number);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
