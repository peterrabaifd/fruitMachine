package fruitMachineMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fruitMachineMVC.fruitView;

public class fruitController implements ActionListener {
	/*
	Controller Class to handle action listening
	*/
	public fruitView GUI;

	public fruitController(fruitView GUI) {
		/*
		Constructor for the CONTROLLER. Simply ties the view to the controller so action listening works.
		*/
		this.GUI = GUI;
	}

	public void actionPerformed(ActionEvent e) {
		/*
		The action listener is split into 2 if statements for the 2 buttons.
		*/
		Object source = e.getSource();
		if (source.equals(GUI.spinButton)) {
			GUI.model.spin();
			GUI.labelUpdate();
			if (GUI.model.winCheck()) {
				GUI.labelUpdate();
				GUI.spinButton.setEnabled(false);
			}
		}
		if (source.equals(GUI.newGameButton)) {
			GUI.model.reset();
			GUI.labelUpdate();
			GUI.spinButton.setEnabled(true);
		}
	}
	
	
	
}
