import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUICalculator extends JFrame {

	private JTextField num1Field;
	private JTextField num2Field;
	private JButton addButton;
	private JTextField resultField;
	
	public SimpleGUICalculator() {
		setTitle("Simple GUI Calculator");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		num1Field = new JTextField(10);
		num2Field = new JTextField(10);
		addButton = new JButton("Add");
		resultField = new JTextField(10);
		resultField.setEditable(false);
		
		setLayout(new java.awt.FlowLayout());
		
		add(new JLabel("Number 1:"));
		add(num1Field);
		add(new JLabel("Number 2:"));
		add(num2Field);
		add(addButton);
		add(new JLabel("Reault: "));
		add(resultField);
		
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addNumbers();
				
			}
		});
	}
	
	private void addNumbers() {
		try {
			double num1 = Double.parseDouble(num1Field.getText());
			double num2 = Double.parseDouble(num2Field.getText());
			
			double result = num1 + num2;
			
			resultField.setText(String.valueOf(result));
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.");
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new SimpleGUICalculator().setVisible(true);				
			}
			
		});
	}
}
