import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DarkModeHelloWorld extends JFrame {
	private JPanel contentPanel;
	private JButton darkModeButton;
	private JLabel helloLabel;
	private boolean isDarkMode = false;
	
	public DarkModeHelloWorld() {
		setTitle("Dark Mode Hello World");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		add(contentPanel);
		
		darkModeButton = new JButton("Switch to DarlMaode");
		darkModeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				toggleDarkMode();
				
			}
			
		});
		contentPanel.add(darkModeButton, BorderLayout.SOUTH);
		
		helloLabel = new JLabel("Hello, World!", SwingConstants.CENTER);
		helloLabel.setFont(new Font("Arial", Font.BOLD, 24));
		contentPanel.add(helloLabel, BorderLayout.CENTER);
	}
	
	private void toggleDarkMode() {
		isDarkMode = !isDarkMode;
		if (isDarkMode) {
			contentPanel.setBackground(Color.DARK_GRAY);
			darkModeButton.setText("Switch to Light Mode");
			darkModeButton.setForeground(Color.WHITE);
			helloLabel.setForeground(Color.WHITE);
		} else {
			contentPanel.setBackground(Color.WHITE);
			darkModeButton.setText("Switch to Dark Mode");
			darkModeButton.setForeground(Color.BLACK);
			helloLabel.setForeground(Color.BLACK);
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				DarkModeHelloWorld darkModeHelloWorld = new DarkModeHelloWorld();
				darkModeHelloWorld.setVisible(true);
				
			}
			
		});
	}
}
