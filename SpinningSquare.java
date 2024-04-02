import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpinningSquare extends JPanel implements ActionListener {
	private int angle = 0;
	private Timer timer;
	
	public SpinningSquare() {
		timer = new Timer(20, this);
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		int width = getWidth();
		int height = getHeight();
		
		int size = Math.min(width,  height)/ 2;
		
		int x = (width - size) / 2;
		int y = (height - size) / 2;
		
		g2d.setColor(Color.BLUE);
		g2d.rotate(Math.toRadians(angle), x + size / 2, y + size / 2);
		g2d.fillRect(x, y, size, size);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		angle++;
		if (angle >= 360) {
			angle = 0;
		}
		repaint();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Spinning Square");
			frame.setSize(400, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(new SpinningSquare());
			frame.setVisible(true);
		});
	}
}
