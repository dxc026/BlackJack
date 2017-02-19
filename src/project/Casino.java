package project;

import java.util.Scanner;

public class Casino {
	public static void main(String[] args) {
		Casino c = new Casino();
		c.runCasino();
	}

	public void welcomeCasino() {

		System.out.println("  Welcome to The Luxurious toString(Dev) Casino!");
		System.out.println("|------------------------------------------------|");
		System.out.println("|                CARD GAME MENU                  |");
		System.out.println("|------------------------------------------------|");
		System.out.println("|                                                |");
		System.out.println("|    1. tS BlacJack                              |");
		System.out.println("|    2. Coming Soon                              |");
		System.out.println("|    3. Coming Soon                              |");
		System.out.println("|    4. Coming Soon                              |");
		System.out.println("|    5. Coming Soon                              |");
		System.out.println("|                                                |");
		System.out.println("|------------------------------------------------|");
		System.out.println("\nWhat would you like to do?");
	}

	public void runCasino() {
		welcomeCasino();
		while (true) {
			Scanner key = new Scanner(System.in);
			int menuChoice = key.nextInt();

			if (menuChoice == 1) {
				welcomeBlackJack();
			} else {
				System.out.println("Invalid Selection! Please Try Again!");

			}

		}
	}
	
	public void welcomeBlackJack(){
		System.out.println("|------------------------------------------------|");
		System.out.println("|               tS BLACK JACK MENU               |");
		System.out.println("|------------------------------------------------|");
		System.out.println("|                                                |");
		System.out.println("|    1. Play                                     |");
		System.out.println("|    2. About tS                                 |");
		System.out.println("|    3. Quit                                     |");
		System.out.println("|                                                |");
		System.out.println("|------------------------------------------------|");
		System.out.println("What would you like to do?");
		
		Scanner key = new Scanner(System.in);
		int bljaChoice =  key.nextInt();
		
		
			if(bljaChoice == 1){
				Game game = new Game();
				game.runGame();
			}
			else if( bljaChoice == 2){
				AboutToString abts = new AboutToString();
				abts.aboutTS();
				welcomeBlackJack();
				
			}
			else if(bljaChoice == 3){
				System.out.println("Thank you! Please Come Again!");
				System.exit(0);
				
			}
		}
	
}
