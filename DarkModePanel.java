import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DarkModePanel extends JFrame {
	private JPanel contentPanel;
	private JButton darkModeButton;
	private boolean isDarkMode = false;
	
	public DarkModePanel() {
		setTitle("Dark Mode Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		add(contentPanel);
		
		darkModeButton = new JButton("switch to Dark Mode");
		darkModeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toggleDarkMode();
			}
		});
		
		contentPanel.add(darkModeButton, BorderLayout.SOUTH);
	}
	
	private void toggleDarkMode() {
		isDarkMode = !isDarkMode;
		if (isDarkMode) {
			contentPanel.setBackground(Color.DARK_GRAY);
			darkModeButton.setText("Switch to Light Mode");
			darkModeButton.setForeground(Color.WHITE);
		} else {
			contentPanel.setBackground(Color.WHITE);
			darkModeButton.setText("Switch to Dark Made");
			darkModeButton.setForeground(Color.BLACK);
		}
	}
	
	public static void main(String[] arga) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				DarkModePanel darkModePanel = new DarkModePanel();
				darkModePanel.setVisible(true);
			}
		});
	}
}
