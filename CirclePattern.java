import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CirclePattern extends JFrame {
	private static final int WIDTH = 500;
	private static final int HEIGHT= 500;
	
	public CirclePattern() {
		setTitle("Circle Pattern");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		CirclePanel circlePanel = new CirclePanel();
		add(circlePanel);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new CirclePattern());
	}
}
class CirclePanel extends JPanel {
	private static final int NUM_CIRCLE = 50;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Random random = new Random();
		
		for (int i = 0; i< NUM_CIRCLE; i++) {
			int x = random.nextInt(getWidth());
			int y = random.nextInt(getHeight());
			int diameter = random.nextInt(50) + 10;
			
			g.setColor(new Color(random.nextInt(256), random.nextInt(256),random.nextInt(256)));
			g.fillOval(x, y, diameter, diameter);
		} 
	}
}
