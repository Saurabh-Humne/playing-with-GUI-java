import javax.swing.*;
import java.awt.*;

public class SquareDrawer extends JFrame {
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	
	public SquareDrawer() {
		setTitle("Square Drawer");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.clearRect(0,0, WIDTH, HEIGHT);
		
		int sideLength = 100;
		int x = (WIDTH - sideLength)/2;
		int y = (HEIGHT - sideLength)/2;
		
		g2d.setColor(Color.BLUE);
		g2d.fillRect(x,y,sideLength, sideLength);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SquareDrawer().setVisible(true);
			}
		});
	}
}
