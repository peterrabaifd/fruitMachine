package fruitMachineMVC;

import java.util.LinkedHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class fruitModel {

	public int balance;
	public String card1;
	public String card2;
	public String card3;
	public String balanceLabelText;
	public String msgLabelText;
	public String winfailLabelText;
	LinkedHashMap<Integer, String> cardMap = new LinkedHashMap<Integer, String>();
	
	public fruitModel() {
		/*
		The constructor for the MODEL. Initialises all the model fields to their starting values.
		*/
		this.balance = 100;
		cardMap.put(0, "ace.png");
		cardMap.put(1, "king.png");
		cardMap.put(2, "queen.png");
		cardMap.put(3, "joker.png");
		cardMap.put(4, "jack.png");
		card1 = "king.png";
		card2 = "queen.png";
		card3 = "jack.png";
		balanceLabelText = "Balance: " + this.balance;
		msgLabelText = "Welcome!";
		winfailLabelText = "";
	}
	
	public void spin() {
		/*
		This method handles what should happen when the spin button is pressed. It will randomise the 3 cards, update the balance and the labels.
		*/
		int randomNum1 = 0;
		int randomNum2 = 0;
		int randomNum3 = 0;
		int jokerCount = 0;
		randomNum1 = ThreadLocalRandom.current().nextInt(0, 5);
		card1 = cardMap.get(randomNum1);
		randomNum2 = ThreadLocalRandom.current().nextInt(0, 5);
		card2 = cardMap.get(randomNum2);
		randomNum3 = ThreadLocalRandom.current().nextInt(0, 5);
		card3 = cardMap.get(randomNum3);
		
		/*
	 	This nested if statement is the heart of the game. As per the spec, checks for jokers first. 2 or 3 of a kind are only check if no jokers.
		*/
		if((randomNum1 == 3) || (randomNum2 == 3) || (randomNum3 == 3)) {
			if(randomNum1 == 3) {
				balance -= 25;
				jokerCount++;
			}
			if(randomNum2 == 3) {
				balance -= 25;
				jokerCount++;
			}
			if(randomNum3 == 3) {
				balance -= 25;
				jokerCount++;
			}
			balanceLabelText = ("Balance: " + balance);
			msgLabelText = (jokerCount + " Jokers. You lose " + (jokerCount*25) + " points.");
		}else {
			if(randomNum1 == randomNum2 && randomNum2 == randomNum3) {
				balance += 50;
				balanceLabelText = ("Balance: " + balance);
				msgLabelText = ("Three of a kind. You get 50 points.");
			}else if((randomNum1 == randomNum2 && randomNum2 != randomNum3) || (randomNum1 == randomNum3 && randomNum2 != randomNum3) || (randomNum2 == randomNum3 && randomNum1 != randomNum3)) {
				balance += 20;
				balanceLabelText = ("Balance: " + balance);
				msgLabelText = ("Two of a kind. You get 20 points.");
			}else {
				balanceLabelText = ("Balance: " + balance);
				msgLabelText = ("No luck. You dont get any points this round.");
			}
		}
	}
	
	public boolean winCheck() {
		/*
		This method checks the win/fail conditions. Returns a boolean which the view responds to accordingly.
		*/
		if (balance < 0) {
			winfailLabelText = ("Your balance fell below 0. You lose!");
			return true;
		}else if(balance >= 150) {
			winfailLabelText = ("Your balance is 150 or more. You win!");
			return true;
		}
		return false;
	}
	
	public void reset() {
		/*
		Method to reset the whole game with all fiels back to their initial states.
		*/
		this.balance = 100;
		card1 = "king.png";
		card2 = "queen.png";
		card3 = "jack.png";
		balanceLabelText = "Balance: " + this.balance;
		msgLabelText = "Welcome!";
		winfailLabelText = "";
	}
	
}
