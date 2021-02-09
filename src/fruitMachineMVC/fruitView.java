package fruitMachineMVC;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings({ "serial" })
public class fruitView extends JFrame {

	
	/*
	This class is the VIEW part of the MVC architecture. It contains all the GUI elements.
	*/
	public fruitModel model;
	public ActionListener controller;
	private JPanel contentPane;
	JLabel box1Label;
	JLabel box2Label;
	JLabel box3Label;
	JLabel balanceLabel;
	JLabel msgLabel;
	JLabel winfailLabel;
	JButton spinButton;
	JButton newGameButton;

	public fruitView() {
		/*
		The constructor initialises all the GUI elements at the appropriate location, size and sets their content where necessary.
		*/
		model = new fruitModel();
		controller = new fruitController(this);
		setTitle("FruitMachine GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		box1Label = new JLabel("");
		box1Label.setIcon(new ImageIcon(model.card1));
		box1Label.setBounds(10, 340, 80, 129);
		contentPane.add(box1Label);
		
		box2Label = new JLabel("");
		box2Label.setIcon(new ImageIcon(model.card2));
		box2Label.setBounds(100, 340, 80, 129);
		contentPane.add(box2Label);
		
		box3Label = new JLabel("");
		box3Label.setIcon(new ImageIcon(model.card3));
		box3Label.setBounds(190, 340, 80, 129);
		contentPane.add(box3Label);

		balanceLabel = new JLabel(model.balanceLabelText);
		balanceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		balanceLabel.setBounds(10, 11, 542, 60);
		contentPane.add(balanceLabel);
		
		msgLabel = new JLabel(model.msgLabelText);
		msgLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		msgLabel.setBounds(10, 82, 542, 60);
		contentPane.add(msgLabel);
		
		winfailLabel = new JLabel(model.winfailLabelText);
		winfailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		winfailLabel.setBounds(10, 153, 542, 60);
		contentPane.add(winfailLabel);
		
		//SPIN BUTTON***********************************************************************************************
		spinButton = new JButton("Spin");
		spinButton.addActionListener(controller);
		spinButton.setBounds(440, 340, 112, 23);
		contentPane.add(spinButton);
		
		//NEWGAME BUTTON***********************************************************************************************
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(controller);
		newGameButton.setBounds(440, 374, 112, 23);
		contentPane.add(newGameButton);
	}
	
	public void labelUpdate() {
		/*
		This method simply updates all 6 labels based on the state of the model.
		*/
		box1Label.setIcon(new ImageIcon(model.card1));
		box2Label.setIcon(new ImageIcon(model.card2));
		box3Label.setIcon(new ImageIcon(model.card3));
		balanceLabel.setText(model.balanceLabelText);
		msgLabel.setText(model.msgLabelText);
		winfailLabel.setText(model.winfailLabelText);
	}
	
}
