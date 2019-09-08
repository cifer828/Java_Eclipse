import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
	
	public static int getUserChoice(Scanner readInput){
		/**
		* @param readInput
		* : Scanner passed from main method
		* ask the user to select a choice and detect input error
		*/
		int userChoice;
		System.out.println("Welcome to  Qiuchen Zhang's Handy Calculator \n\n\t1. Addition\n\t2. Subtraction\n\t3. Multiplication\n" +
				 "\t4. Division\n\t5. Exit\n");
		do{
			try{
				System.out.printf("\nWhat would you like to do?");
				userChoice = readInput.nextInt();
				if (userChoice >= 1 && userChoice <= 5) {
					break; // Got it, done
					} 
				else { 
					System.out.println("You have not entered a number between 1 and 5. Try again.");
					readInput.nextLine();
				}
			}
			catch(final InputMismatchException e)	// input wrong data type
			{
				System.out.println("You have entered an invalid choice. Try again.");
				readInput.nextLine(); // gobble up the wrong input
			}
		} while(true);	
		return userChoice;
	}
	
	public static void getTwoFloats(float [] myFloats, Scanner readInput){
		/**
		* @param myFloats
		* : assigns two floats from user into the array elements
		* @param readInput
		* : Scanner passed from main method
		* ask the user to input two floats for calculation and detect input error
		*/
		do { // Loop until we have correct input
			try {
				myFloats[0] = readInput.nextFloat();
				myFloats[1] = readInput.nextFloat();
				break;
			} 
			catch (final InputMismatchException e) {
				System.out.print("You have entered an invalid floats please re-enter:");
				readInput.nextLine();
				// discard non-float input
				continue;
				// keep looping until you found right one
			}
		} while (true);
		//clear the input buffer for next read
		readInput.nextLine();
	}

	public static void add(float [] myFloats, Scanner readInput){
		/**
		* @param myFloats
		* : assigns two floats from user into the array elements
		* @param readInput
		* : Scanner passed from main method
		* add two floats
		*/
		System.out.print("\nPlease enter two floats to add, seperated by a space:");
		getTwoFloats(myFloats, readInput);
		System.out.printf("Result of adding %.2f and %.2f is %.2f.\n\n", myFloats[0], myFloats[1],  myFloats[0] + myFloats[1]);
	}
	
	public static void subtract(float [] myFloats, Scanner readInput){
		/**
		* @param myFloats
		* : assigns two floats from user into the array elements
		* @param readInput
		* : Scanner passed from main method
		* add two floats
		*/
		System.out.print("\nPlease enter two floats to subtract, seperated by a space:");
		getTwoFloats(myFloats, readInput);
		System.out.printf("Result of subtracting %.2f from %.2f is %.2f.\n\n", myFloats[1], myFloats[0],  myFloats[0] - myFloats[1]);
	}
	
	public static void multiply(float [] myFloats, Scanner readInput){
		/**
		* @param myFloats
		* : assigns two floats from user into the array elements
		* @param readInput
		* : Scanner passed from main method
		* add two floats
		*/
		System.out.print("\nPlease enter two floats to multiply, seperated by a space:");
		getTwoFloats(myFloats, readInput);
		System.out.printf("Result of multiplying %.2f and %.2f is %.2f.\n\n", myFloats[0], myFloats[1],  myFloats[0] * myFloats[1]);
	}
	
	
	public static void divide(float [] myFloats, Scanner readInput){
		/**
		* @param myFloats
		* : assigns two floats from user into the array elements
		* @param readInput
		* : Scanner passed from main method
		* add two floats
		*/
		System.out.print("\nPlease enter two floats to divide seperated by a space:");
		do{
//			divide by zero issue
			getTwoFloats(myFloats, readInput);
			if (myFloats[1] == 0){
				System.out.print("You can't divide by zero please re-enter both floats:");
				readInput.nextLine();
				continue;
			}
			else
			{break;}
		} while(true);
		System.out.printf("Result of dividing %.2f by %.2f is %.2f.\n\n", myFloats[0], myFloats[1],  myFloats[0] / myFloats[1]);
	}
	
	
	public static void main(String[] args) {
		int userChoice;
		float [] myFloats = new float[2];
		Scanner rI = new Scanner(System.in);
		do {
			userChoice = getUserChoice(rI);
			switch (userChoice){
			case 1:
				add(myFloats, rI);
				break;
			case 2:
				subtract(myFloats, rI);
				break;
			case 3:
				multiply(myFloats, rI);
				break;
			case 4:
				divide(myFloats, rI);
				break;
			case 5:
				System.out.println("\nThank you for using Qiuchen Zhang's Handy Calculator");	
				return;
			}
			System.out.println("Please enter any key to continue ....");
			rI.next();
		} while (true);
	}

}