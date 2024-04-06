import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RotatingSquare extends JPanel implements ActionListener {
	private int x= 0;
	private int y = 0;
	private int angle = 0;
	private int speedX = 2;
	private int speedY = 2;
	private final int squareSize = 50;
	private final int delay = 10;
	private Timer timer;
	
	public RotatingSquare() {
		timer = new Timer(delay, this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setColor(Color.RED);
		g2d.rotate(Math.toRadians(angle), x + squareSize / 2, y + squareSize / 2);
		g2d.fillRect(x, y, squareSize, squareSize);
		
		Toolkit.getDefaultToolkit().sync();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		x += speedX;
		y += speedY;
		angle += 2;
		
		if (x <= 0 || x >= getWidth() - squareSize) {
			speedX = -speedX;
		}
		if (y <= 0 || y >= getHeight() - squareSize) {
			speedY = - speedY;
		}
		
		repaint();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Rotating Square");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(400, 400);
			frame.add(new RotatingSquare());
			frame.setVisible(true);
		});
	}
}
