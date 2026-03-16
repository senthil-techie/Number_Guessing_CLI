package NGM;


import java.util.Scanner;

public class Number_Guess {
	
	Scanner scan = new Scanner(System.in);
	
	
	int highScore = 0;
	
	int min = 1;
	int max = 100;
	String play = "yes";
	
	int number = (int)(Math.random() * (max - min + 1)) + min  ;
	
	public void chooseLevel(String level) {
		int e = 10;
		int m = 5;
		int h = 3;
		
		switch(level) {
		case "easy":
			System.out.println("You choose " + level + " level soo.. you have " + e + " chances to guess the correct number.");
			guess(e);
			break;
		case "medium":
			System.out.println("You choose " + level + " level soo.. you have " + m + " chances to guess the correct number.");
			guess(m);
			break;
		case "hard":
			System.out.println("You choose " + level + " level soo.. you have " + h + " chances to guess the correct number.");
			guess(h);
			break;
		 default:
	            System.out.println("Invalid level. Please type easy / medium / hard");
	        
			}
		
	}
	
	public void guess(int n) {
		long startTime = System.currentTimeMillis();
//		System.out.println(number);
		
		while(n > 0) {
			System.out.print("you "+ n + " chances to Enter you choice: ");
			int num = scan.nextInt();
			
			if(num == number) {
				highScore = Math.max(n, highScore);
				long endTime = System.currentTimeMillis();
				 long totalTime = (endTime - startTime) / 1000;
				 
				System.out.println("Congratulations! You guessed the correct number in " + n + " attempts and Time taken: " + totalTime + " seconds ");
				System.out.println("your HighScore is: " + highScore);
				return;
			}else if(num > number) {
				System.out.println("Incorrect! The number is less than " + num +" .");
			}else {
				System.out.println("Incorrect! The number is greater than " + num + " .");
			}
			n--;
		}	
		long endTime = System.currentTimeMillis();
	    long totalTime = (endTime - startTime) / 1000;
		 System.out.println("Oops! You are out of chances. The correct number was: " + number + " attempts and Time taken: " + totalTime + " seconds ");
		 System.out.println("your HighScore is: " + highScore);
		 
	}
	
	public static void main(String[] args) {
		
		Number_Guess ng = new Number_Guess();
		
		System.out.println("Welcome to the Number Guessing Game!");
		System.out.println("I'm thinking of a number between 1 and 100.");
		
		
		System.out.println("1. Easy (10 chances)"); 
		System.out.println("2. Medium (5 chances)"); 
		System.out.println("3. Hard (3 chances)");
		
		boolean yes = true;
		
		while(yes) {
			ng.scan.nextLine();
			
			
			System.out.print("please select the difficulty level:");
			String level = ng.scan.nextLine().toLowerCase();
			
			ng.chooseLevel(level);
			
			
			
			System.out.print(" Do you want to play again? :) (yes/no) :");
			  yes = ng.scan.nextBoolean();
			  
		  if (yes) {
            ng.number = (int) (Math.random() * (ng.max - ng.min + 1)) + ng.min;
            }
			
			
		}
		
		System.out.println("Thank you for played the game!!");
		
		
		
		
	}

}
