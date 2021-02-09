package fruitMachineMVC;

import java.awt.EventQueue;

public class FruitMachine{
	/*
	Main method just to initialise the frame.
	*/
	public FruitMachine() {
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fruitView frame = new fruitView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
