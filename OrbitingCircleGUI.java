import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrbitingCircleGUI extends JFrame {
	private Timer timer;
	private int centerX = 200;
	private int centerY = 200;
	private int orbitRadius = 100;
	private double angle = 0;
	private int orbitSpeed = 5;
	
	public OrbitingCircleGUI() {
		setTitle("Orbitin Circle");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawOrbitingCircle(g);
			}
		};
		
		add(panel);
		setVisible(true);
		
		timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				angle += Math.toRadians(orbitSpeed);
				repaint();
			}
		});
		timer.start();
	}
	
	private void drawOrbitingCircle(Graphics g) {
		int x = (int) (centerX + orbitRadius * Math.cos(angle));
		int y = (int) (centerY + orbitRadius * Math.sin(angle));
		
		g.setColor(Color.BLACK);
		g.fillOval(centerX - 10,  centerY - 10,  20,  20);
		g.setColor(Color.RED);
		g.fillOval(x - 5, y - 5, 10, 10);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new OrbitingCircleGUI();
			}
		});
	}
}
