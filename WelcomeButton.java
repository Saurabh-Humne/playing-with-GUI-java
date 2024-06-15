import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeButton {

	private JFrame frame;
	
	public WelcomeButton() {
		frame = new  JFrame("Welcome Button Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setLayout(new FlowLayout());
		
		JButton welcomeButton = new JButton("Click me!");
		welcomeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				welcomeButton.setText("Welcome!");
			}
		});
		
		frame.add(welcomeButton);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WelcomeButton();
			}
		});
	}
}
