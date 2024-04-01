import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingShapeGUI extends JPanel {
	private int x = 0;
	private int y = 0;
	private int xSpeed = 1;
	private int ySpeed = 1;
	private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE};
	private Color currentColor = colors[0];
	private int colorIndex = 0;
	private final int DIAMETER = 50;
	
	public BouncingShapeGUI() {
		Timer timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				move();
				checkBounds();
				repaint();
			}
		});
		timer.start();
	}
	
	private void move() {
		x += xSpeed;
		y += ySpeed;
	}
	
	private void checkBounds() {
		if (x <= 0 || x >= getWidth() - DIAMETER) {
			xSpeed = -xSpeed;
			changeColor();
		}
		if (y <= 0 || y >= getHeight() - DIAMETER) {
			ySpeed = -ySpeed;
			changeColor();
		}
	}
	
	private void changeColor() {
		colorIndex = (colorIndex + 1) % colors.length;
		currentColor = colors[colorIndex];
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(currentColor);
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Bouncing Shape");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		
		BouncingShapeGUI bouncingShape = new BouncingShapeGUI();
		frame.add(bouncingShape);
		
		frame.setVisible(true);
	}
}
