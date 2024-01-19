import javax.swing.*;
import java .awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurvedWavePattern extends JFrame {
	
	private int yOffset = 50;
	
	public CurvedWavePattern() {
		setTitle("Curved Wave Pattern");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Timer timer = new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				yOffset = (yOffset + 5)% getHeight();
				repaint();
			}
		});
		timer.start();
		
		WavePanel wavePanel = new WavePanel();
		add(wavePanel);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class WavePanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponents(g);
			drawCurvedWave(g);
		}
		
		private void drawCurvedWave(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.BLUE);
			
			int width = getWidth();
			int height = getHeight();
			
			int waveCount = 4;
			int waveLength = width / waveCount;
			
			for (int i = 0; i< waveCount; i++) {
				int x = i * waveLength;
				int y = yOffset +(i % 2 == 0 ? 1: -1)*(int)(50* Math.sin((double)(yOffset +x)/ 50));
				g2d.drawArc(x, y, waveLength, height, 0, 180);
			}
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new CurvedWavePattern();
			}
		});
	}
}
