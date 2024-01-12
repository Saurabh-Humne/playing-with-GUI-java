import javax.swing.*;
import java.awt.*;


public class TrianglePattern extends JFrame {
	
	
	public TrianglePattern() {
		setTitle("Triangle attern");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawTriangle(g);
	}
	
	private void drawTriangle(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		int triangleHeight = height /2;
		
		for (int i = 0; i <= triangleHeight; i++) {
			String line = createStars(i);
			g.drawString(line, (width - g.getFontMetrics().stringWidth(line)) / 2, i * 15);
		}
	}
	
	private String createStars(int count) {
		StringBuilder stars = new StringBuilder();
		for (int i = 0; i< count; i++) {
			stars.append("* ");
		}
		return stars.toString();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new TrianglePattern());
	}
}
