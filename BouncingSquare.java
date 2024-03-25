import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingSquare extends JFrame implements ActionListener{
	
	private int squareSize = 50;
	private int x = 0;
	private int y = 0;
	private int dx = 2;
	private int dy = 2;
	private Timer timer;
	
	public BouncingSquare() {
		setTitle("Bouncing Square");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(400, 400));
		timer = new Timer(10, this);
		timer.start();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLUE);
		g2d.fillRect(x, y, squareSize, squareSize);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		x += dx;
		y += dy;
		
		if (x <= 0 || x + squareSize >= getWidth()) {
			dx = -dx;
		}
		
		if (y <= 0 || y + squareSize >= getHeight()) {
			dy =-dy;
		}
		
		repaint();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			BouncingSquare frame = new BouncingSquare();
			frame.pack();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		});
	}
}
