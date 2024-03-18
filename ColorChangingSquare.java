import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChangingSquare extends JFrame {
	
	private JPanel squarePanel;
	private JLabel colorLabel;
	
	public ColorChangingSquare() {
		setTitle("Color Changing Squate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,250);
		
		squarePanel = new JPanel();
		squarePanel.setBackground(Color.RED);
		squarePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeColor();
			}
		});
		
		colorLabel = new JLabel();
		updateColorLabel(squarePanel.getBackground());
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BorderLayout());
		controlPanel.add(squarePanel, BorderLayout.CENTER);
		controlPanel.add(colorLabel, BorderLayout.SOUTH);
		
		add(controlPanel);
		
		setVisible(true);
	}
	
	private void changeColor() {
		Color currentColor = squarePanel.getBackground();
		Color newColor;
		do {
			newColor = new Color(
					(int)(Math.random()* 256),
					(int)(Math.random()* 256),
					(int)(Math.random()* 256)
					);
		} while (newColor.equals(currentColor));
		squarePanel.setBackground(newColor);
		updateColorLabel(newColor);
	}
	
	private void updateColorLabel(Color color) {
		colorLabel.setText("RGB: "+ color.getRed() + ", "+ color.getGreen() + "," + color.getBlue());
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new ColorChangingSquare());
	}
}
