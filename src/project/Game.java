package project;

import java.util.Scanner;

public class Game {

	Scanner key = new Scanner(System.in);

	public void runGame() {
		Dealer dealer = new Dealer();
		dealer.shuffleDeck();
		Player player1 = new Player();
		player1.getHand().addCard(dealer.deal());
		dealer.getHand().addCard(dealer.deal());
		player1.getHand().addCard(dealer.deal());
		dealer.getHand().addCard(dealer.deal());
		showPlayerCards(player1);
		System.out.println("Player Total " + playerTotal(player1));
		showDealerCards(dealer);
		System.out.println("Dealer Total " + dealerTotal(dealer));
		blackJack(player1, dealer);
		System.out.println("|------------------------------------------------|");
		System.out.println("|                                                |");
		System.out.println("|   Player would you like to hit or stay?        |");
		System.out.println("|    1. Hit                                      |");
		System.out.println("|    2. Stay                                     |");
		System.out.println("|                                                |");
		System.out.println("|------------------------------------------------|");
		int hitStay = key.nextInt();

		if (hitStay == 1) {
			playerHit(player1, dealer);
			if (playerTotal(player1) < 21) {
				System.out.println("|------------------------------------------------|");
				System.out.println("|                                                |");
				System.out.println("|   Player would you like to hit or stay?        |");
				System.out.println("|    1. Hit                                      |");
				System.out.println("|    2. Stay                                     |");
				System.out.println("|                                                |");
				System.out.println("|------------------------------------------------|");
				hitStay = key.nextInt();
				if (hitStay == 1) {
					playerHit(player1, dealer);
				} else if (hitStay == 2) {
					playerStay(player1);
					playerStay(player1);
					dealer(dealer);
					if (playerTotal(player1) > dealerTotal(dealer)) {
						System.out.println("Player has the higher hand");
						System.out.println("You win!!!!");
						System.exit(0);
					}
					if (dealerTotal(dealer) > playerTotal(player1)) {
						System.out.println("Dealer has the higher hand");
						System.out.println("Dealer wins!!!!");
						System.exit(0);
					}
					if (dealerTotal(dealer) == playerTotal(player1)) {
						System.out.println("The totals are equal.");
						System.out.println("Draw!!!!");
						System.exit(0);
					}
				}
			}
		} else if (hitStay == 2) {
			playerStay(player1);
			dealer(dealer);
			if (playerTotal(player1) > dealerTotal(dealer)) {
				System.out.println("Player has the higher hand");
				System.out.println("You win!!!!");
				System.exit(0);
			}
			if (dealerTotal(dealer) > playerTotal(player1)) {
				System.out.println("Dealer has the higher hand");
				System.out.println("Dealer wins!!!!");
				System.exit(0);
			}
			if (dealerTotal(dealer) == playerTotal(player1)) {
				System.out.println("The totals are equal.");
				System.out.println("Draw!!!!");
				System.exit(0);
			}

		} else {
			System.out.println("Invalid Entry. Try Again!");
		}

	}

	public void playerHit(Player player, Dealer dealer) {
		player.getHand().addCard(dealer.deal());
		showPlayerCards(player);
		System.out.println("Player Total " + playerTotal(player));

		if (playerTotal(player) > 21) {
			System.out.println("Player has Busted. You lose!!");
			System.exit(0);
		}
		if (playerTotal(player) == 21) {
			System.out.println("Player got Black Jack. You win!!");
			System.exit(0);
		}
	}

	public void playerStay(Player player) {
		System.out.println("Player chooses to stay with: ");
		showPlayerCards(player);
		System.out.println("Player Total " + playerTotal(player));

	}

	public void dealer(Dealer dealer) {
		if (dealerTotal(dealer) <= 16) {
			System.out.println("Dealer choose to hit and gets: ");
			System.out.println();
			dealer.getHand().addCard(dealer.deal());
			showDealerCards(dealer);
			System.out.println("Dealer Total " + dealerTotal(dealer));
		} else if (dealerTotal(dealer) > 16) {
			System.out.println("Dealer chooses to stay with: ");
			System.out.println();
			showDealerCards(dealer);
			System.out.println("Dealer Total " + dealerTotal(dealer));
		}
		if (dealerTotal(dealer) == 21) {
			System.out.println("Dealer has Black Jack! Dealer Wins!");
			System.exit(0);
		}
		if (dealerTotal(dealer) > 21) {
			System.out.println("Dealer has Busted. Dealer Loses!!!!");
			System.exit(0);
		}
	}

	public void blackJack(Player player, Dealer dealer) {
		if (playerTotal(player) == 21 || dealerTotal(dealer) == 21) {
			if (playerTotal(player) == 21) {
				System.out.println("Player got BLack Jack!! Player wins!!");
				System.exit(0);
			} else {
				System.out.println("Dealer got BLack Jack!! Dealer wins!!");
				System.exit(0);
			}
		}

	}

	public static void showPlayerCards(Player player) {
		for (Card c : player.getHand().getCards()) {
			System.out.println("Player: " + c);
		}
	}

	public static void showDealerCards(Dealer dealer) {
		for (Card c : dealer.getHand().getCards()) {
			System.out.println("Dealer: " + c);
		}
	}

	public static int playerTotal(Player player) {
		int total = 0;
		for (Card c : player.getHand().getCards()) {
			total = total + c.getValue();
		}
		return total;
	}

	public static int dealerTotal(Dealer dealer) {
		int total = 0;
		for (Card c : dealer.getHand().getCards()) {
			total = total + c.getValue();
		}
		return total;
	}
}
