package calculator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import utilities.Utilities;

/**
 * You will likely import more than a few Swing and other libraries above.
 * 
 * @author Marcellus Davenport
 * 
 */
public class InterestTableGUI extends JFrame {
	JTextArea textArea;
	JTextField principal;
	JTextField rate;
	JLabel sliderLabel;
	JSlider slider;

	public InterestTableGUI() {
		initUI();
	}

	private void initUI() {

		setLayout(null);

		// creates SimpleInterest button
		JButton simple = new JButton("Simple Interest");
		simple.setBounds(20, 430, 150, 35);
		simple.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!aNumber()) {
					return;
				}
				if (check()) {
					textArea.setText(Utilities.simpleInterestTable(
							Double.parseDouble(principal.getText()),
							Double.parseDouble(rate.getText()),
							slider.getValue()));
				}
			}

		});

		// creates CompoundInterest button
		JButton compound = new JButton("Compound Interest");
		compound.setBounds(175, 430, 150, 35);
		compound.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!aNumber()) {
					return;
				}
				
				if (check()) {
					textArea.setText(Utilities.compoundInterestTable(
							Double.parseDouble(principal.getText()),
							Double.parseDouble(rate.getText()),
							slider.getValue()));
				}
			}
			
		});

		// creates BothInterest button
		JButton both = new JButton("Both Interest");
		both.setBounds(330, 430, 150, 35);
		both.addActionListener(returnListener());

		// creates the text field for the "principal" input
		JLabel principalLabel = new JLabel("Principal:");
		principalLabel.setBounds(10, 340, 60, 25);
		principal = new JTextField();
		principal.setBounds(70, 340, 150, 25);

		// creates the text field for the "rate" input
		JLabel rateLabel = new JLabel("Rate(Percentage):");
		rateLabel.setBounds(235, 340, 130, 25);
		rate = new JTextField();
		rate.setBounds(345, 340, 150, 25);

		// create the text area that displays the calculations
		textArea = new JTextArea();
		//textArea.setBounds(0, 0, 500, 300);
		textArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 500, 300);

		// creates the slider for the number of years
		slider = new JSlider(JSlider.HORIZONTAL, 1, 25, 1);
		slider.setBounds(150, 380, 300, 40);
		slider.setMajorTickSpacing(4);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		sliderLabel = new JLabel("Number of Years:");
		sliderLabel.setBounds(40, 380, 120, 40);

		// adds components to the frame
		add(simple);
		add(compound);
		add(both);
		//add(textArea);
		add(slider);
		add(sliderLabel);
		add(principal);
		add(principalLabel);
		add(rate);
		add(rateLabel);
		add(scrollPane);

		// sets the frame's basic properties
		setTitle("Interest Table Calculator");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	//checks if the fields are empty 
	private boolean check() {
		if (principal.getText().equals("") && rate.getText().equals("")) {
			JOptionPane
					.showMessageDialog(this,
							"Please enter a value for \"Principal\" and \"Rate(Percentage)\".");
			return false;
		} else if (principal.getText().equals("")) {
			JOptionPane.showMessageDialog(this,
					"Please enter a value for \"Principal\".");
			return false;
		} else if (rate.getText().equals("")) {
			JOptionPane.showMessageDialog(this,
					"Please enter a value for \"Rate(Percentage)\".");
			return false;
		}
		return true;
	}
	
	private boolean aNumber() {
		try {
			if (Double.isNaN(Double.parseDouble(principal.getText())) || Double.isNaN(Double.parseDouble(rate.getText()))) {
				
			} 
		} catch (NumberFormatException e) {
			JOptionPane
			.showMessageDialog(this,
					"Please do not include any symbols when entering a value.");
			return false;
		}
		
		return true;
	}
	private ActionListener returnListener() {
		return new newActionListener();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				InterestTableGUI ex = new InterestTableGUI();
				ex.setVisible(true);
			}
		});
	}
	
	//non-anonymous inner class just for the fun of it
	class newActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!aNumber()) {
				return;
			}
			
			if (check()) {
				textArea.setText(Utilities.bothInterestsTable(
						Double.parseDouble(principal.getText()),
						Double.parseDouble(rate.getText()),
						slider.getValue()));
			}
		}
		
	}
}