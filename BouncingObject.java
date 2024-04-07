import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BouncingObject extends JPanel implements ActionListener {
	private int objectX, objectY;
	private int dx = 2, dy = 2;
	private List<Point> pathPoints;
	
	public BouncingObject() {
		objectX = 50;
		objectY = 50;
		pathPoints = new ArrayList<>();
		
		Timer timer = new Timer(10, this);
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillOval(objectX, objectY, 20, 20);
		
		g.setColor(Color.BLUE);
		for (int i = 1 ; i < pathPoints.size(); i++) {
		Point p1 = pathPoints.get(i - 1);
		Point p2 = pathPoints.get(i);
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		objectX += dx;
		objectY += dy;
		
		if (objectX <= 0 || objectX >= getWidth() - 20)
			dx = -dx;
		if (objectY <= 0 || objectY >= getHeight() - 20)
			dy = -dy;
		
		pathPoints.add(new Point(objectX + 10, objectY + 10));
		
		if (pathPoints.size() > 1000)
			pathPoints.remove(0);
		
		repaint();
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Bouncing Object");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		
		BouncingObject bouncingObject = new BouncingObject();
		frame.add(bouncingObject);
		
		frame.setVisible(true);
	}
}
