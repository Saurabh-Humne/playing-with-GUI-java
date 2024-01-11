import javax.swing.*;
import java.awt.*;

public class SmileyFaceGUI extends JFrame {
	
	public SmileyFaceGUI() {
		setTitle("Smiley Face:)");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawSmileyFace(g);
			}
		};
		
		add(panel);
		
		setVisible(true);
	}
	
	private void drawSmileyFace(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(50, 50, 200, 200);
		
		g.setColor(Color.BLACK);
		g.fillOval(90, 100, 30, 30);
		g.fillOval(180, 100, 30, 30);
		
		g.drawArc(100, 140, 100, 60, 0, -180);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()-> new SmileyFaceGUI());
	}

}
