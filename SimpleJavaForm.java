import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleJavaForm extends JFrame {

	private JTextField nameField;
	private JTextField emailField;
	private JLabel resultLabel;
	
	public SimpleJavaForm() {
		setTitle("Simple JavaForm");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 2));
		
		JLabel nameLabel = new JLabel("Name:");
		nameField = new JTextField();
		
		JLabel emailLabel = new JLabel("Email:");
		emailField = new JTextField();
		
		JButton submitButton = new JButton("Submit");
		resultLabel = new JLabel("");
		
		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String email = emailField.getText();
				resultLabel.setText("Hello, "+name+"! Your email is "+email+".");
				
			}
		});
		
		add(nameLabel);
		add(nameField);
		add(emailLabel);
		add(emailField);
		add(new JLabel());
		add(submitButton);
		add(new JLabel());
		add(resultLabel);
		
		setLocationRelativeTo(null);
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new SimpleJavaForm();
		});
	}
}
