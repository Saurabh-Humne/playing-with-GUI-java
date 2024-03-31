import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeChangerGUI extends JFrame{
	private JPanel shapePanel;
	private Timer timer;
	private int currentShapeIndex;
	
	public ShapeChangerGUI() {
		setTitle("Shape Changer");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		shapePanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawCurrentShape(g);
			}
		};
		
		timer = new Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentShapeIndex = (currentShapeIndex + 1)% 3;
				shapePanel.repaint();
			}
		});
		
		timer.start();
		
		add(shapePanel);
		setVisible(true);
	}
	
	private void drawCurrentShape(Graphics g) {
		switch (currentShapeIndex) {
		case 0:
			g.setColor(Color.RED);
			g.fillRect(100, 100, 200, 200);
			break;
		case 1:
			g.setColor(Color.BLUE);
			g.fillOval(100, 100, 200, 200);
			break;
		case 2:
			int[] xPoints = {100, 200, 300};
			int[] yPoints = {300, 100, 300};
			g.setColor(Color.GREEN);
			g.fillPolygon(xPoints, yPoints, 3);
			break;
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(ShapeChangerGUI::new);
	}
}
