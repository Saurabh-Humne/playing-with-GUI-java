import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ColorChangingPanel extends JPanel implements ActionListener {
	private Timer timer;
	private Random random;
	
	public ColorChangingPanel() {
		timer = new Timer(1000, this);
		random = new Random();
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		
		int red = random.nextInt(256);
		int green = random.nextInt(256);
		int blue = random.nextInt(256);
		
		setBackground(new Color(red, green, blue));
		
		g.setColor(getBackground());
		g.fillRect(0, 0, width, height);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Color Changing Panel");
		ColorChangingPanel panel = new ColorChangingPanel();
		frame.setContentPane(panel);
		frame.setSize(400,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
}
