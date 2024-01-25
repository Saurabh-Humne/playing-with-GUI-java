import javax.swing.*;
import java.awt.*;

public class CircleDrawingExample extends JFrame{
	
	public CircleDrawingExample() {
		setTitle("Circle Drawing Example");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawCircle(g);
	}
	
	private void drawCircle(Graphics g) {
		int centerX = getWidth()/2;
		int centerY = getHeight()/2;
		int radius = 100;
		
		// Draw the circle
		g.setColor(Color.PINK);// Set color to blue
		g.fillOval(centerX - radius, centerY - radius, 2* radius, 2 * radius);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			CircleDrawingExample example = new CircleDrawingExample();
			example.setVisible(true);
		});
	}
}
