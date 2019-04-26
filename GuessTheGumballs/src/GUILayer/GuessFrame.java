package GUILayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GuessFrame extends JFrame{

	private JLabel lblMsg;
	private JTextField txtInput;
	private JButton btnCheck;
	Random rand = new Random();
	private int number = rand.nextInt(1000);
	private int tries = 0;
	
	public GuessFrame() {
		
		super("Guess The Gumballs");
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setFocusable(true);
		this.setLocationRelativeTo(null);
		this.addComponent();
	}

	private void addComponent() {
		
		
		lblMsg = new JLabel("Guess a number between 1 and 1000");
		lblMsg.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 20));
		lblMsg.setForeground(Color.BLUE);
		lblMsg.setBounds(20, 20, 350, 50);
		add(lblMsg);
		
		txtInput = new JTextField();
		txtInput.setToolTipText("insert your guess here");
		txtInput.setBackground(Color.green);
		txtInput.setFont(new Font("Serif", Font.BOLD, 15));
		txtInput.setBounds(50, 110, 110, 30);
		add(txtInput);
		
		btnCheck = new JButton("Check");
		btnCheck.setForeground(Color.BLUE);
		btnCheck.setBounds(50, 160, 90, 30);
		btnCheck.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
		        
		        int guess;
		        guess = Integer.parseInt(txtInput.getText());
		        
		        if (tries!=16) {
		        	
		            if (guess == number){
		            	
		                JOptionPane.showMessageDialog(null, "You Win! It took you "+(tries)+ " tries");
		                int r = JOptionPane.showConfirmDialog(null, "Want to play again?");
			        	if (r==1) {
							
			        		System.exit(0);
						}
			        	else {
			        		
			        	     tries=0;
			        	}
		            }

		            else if(guess < number){
		            	
		            	tries++;
		            	JOptionPane.showMessageDialog(null, "Number is too low, try again");
		            	
		            }

		            else if(guess > number){
		            	
		            	tries++;
		            	JOptionPane.showMessageDialog(null, "Number is too high, try again");
		            }
		        }
		        else if(tries==16) {
		        	JOptionPane.showMessageDialog(null, "Game Over");
		        	int r = JOptionPane.showConfirmDialog(null, "Want to play again?");
		        	if (r==1) {
						
		        		System.exit(0);
					}
		        	else {
		        		
		        	     tries=0;
		        	}
		        }
			}

		});
		add(btnCheck);
		
	}
}
