import javax.swing.*;
import java.awt.event.*;

public class CToFConverter extends JFrame implements ActionListener {

	private JTextField celsiusField;
	private JTextField fahrenheitField;
	private JButton convertButton;
	
	public CToFConverter() {
		setTitle("Celsius to Fahrenheit Converter");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel celsiusLabel = new JLabel("Celsius: ");
		celsiusField = new JTextField(10);
		JLabel faherenheitLabel = new JLabel("Fahrenheit: ");
		fahrenheitField = new JTextField(10);
		fahrenheitField.setEditable(false);
		convertButton = new JButton("Convert");
		convertButton.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.add(celsiusLabel);
		panel.add(celsiusField);
		panel.add(faherenheitLabel);
		panel.add(fahrenheitField);
		panel.add(convertButton);
		add(panel);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == convertButton) {
			try {
				double celsius = Double.parseDouble(celsiusField.getText());
				double fahrenheit = (celsius * 9/5) +32 ;
				fahrenheitField.setText(String.format("%.2f", fahrenheit));
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Invalid input. please enter a valid number.","error", JOptionPane.ERROR_MESSAGE );
			}
		}
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(CToFConverter::new);;
	}
	
}
