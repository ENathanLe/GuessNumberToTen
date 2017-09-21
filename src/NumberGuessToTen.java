import java.util.Scanner;

import javax.swing.JOptionPane;

public class NumberGuessToTen {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int money1 = 50, money2 = 50;
		int p1, p2, turn1 = 1, turn2 = 2;
		int moneyBet1 = 0, moneyBet2 = 0;
		int winner;
		
		int playCount = 0, win1 = 0, win2 = 0;
		
		do {
			
			moneyBet1 = checkReal(money1, turn1);
			moneyBet2 = checkReal(money2, turn2);

			
			p1 = checkReal10(turn1);
			p2 = checkReal10(turn2);
		
			playCount++;
			if (p1 > p2) {
				if (p1 - 3 > p2) {
					winner = 2;
				} else {
					winner = 1;

				}
			} else if (p2 == p1) {
				winner = 0;// need to make for condition equal
			} else if (p2 - 3 > p1) {// player 2 is greater than 3 away from p1
				winner = 1;
			} else {
				winner = 2;// p2 is greater than p1, but nor more than 3
			}
			if (winner == 1) {
				money1 = money1 + moneyBet1;
				money2 = money2 - moneyBet2;
				System.out.println("Player 1 won and got " + moneyBet1 + " money");
				System.out.println("Player 2 lost " + moneyBet2 + " money");
				win1 ++;
			} else if(winner == 2) {
				money2 = money2 + moneyBet2;
				money1 = money1 - moneyBet1;
				System.out.println("Player 2 won and got " + moneyBet2 + " money");
				System.out.println("Player 1 lost " + moneyBet1 + " money");
				win2 ++;
			}
			else {
				JOptionPane.showMessageDialog(null, "You tied");
			}
			System.out.println("\nplayer 1 now has " + money1 + " money, and won " + win1 + "games");
			System.out.println("player 2 now has " + money2 + " money, and won " + win2 + "games");
			System.out.println("You have played " + playCount + " games now");
			
		} while (money1 > 0 && money2 > 0 && playCount < 10);
		
		System.out.println("The bank is bankrupt, the player with more money has won");
		if(money1 > money2) {
			System.out.println("player 1 has won");
		} else {
			System.out.println("player 2 has won");
		}
	}

	private static int checkReal10(int playerTurn) {
		// TODO Auto-generated method stub
		int pChoice;
		String checkChoice;
		do {
			try {
				checkChoice = JOptionPane.showInputDialog("player " + playerTurn + ", pick your poison(number)");
				pChoice = Integer.parseInt(checkChoice);
			} catch (Exception e) {
				pChoice = 0;
			}
			if (pChoice < 1 || pChoice > 10) {
				JOptionPane.showMessageDialog(null, "Stop cheating, try again");
				pChoice = 0;
			}
		} while (pChoice < 1 || pChoice > 10);
		return pChoice;
	}
	
	

	private static int checkReal(int money, int playerTurn) {
		// TODO Auto-generated method stub
		int moneyBet;
		String checkBet;
		do {
			try {
				checkBet = JOptionPane.showInputDialog("player " + playerTurn + ", how much do you bet? minimum 1. You have " + money + " money.");
				moneyBet = Integer.parseInt(checkBet);
			} catch (Exception e) {
				moneyBet = 0;
			}
			if (moneyBet < 1 || moneyBet > money) {
				JOptionPane.showMessageDialog(null, "Stop cheating, try again");
				moneyBet = 0;
			}
		} while (moneyBet < 1);
		return moneyBet;
	}

}

/* 			public static void printHealth(int a){
 * 		visibility modifier
 * 				not sure
 * 						return type		input
 * 
 * }
 */





