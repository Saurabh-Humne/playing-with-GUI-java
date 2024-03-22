import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DigitalClock extends JFrame {
	
	private JLabel timeLabel;
	
	public DigitalClock() {
		setTitle("Digital Clock");
		setSize(300, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		timeLabel = new JLabel();
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
		getContentPane().add(timeLabel);
		
		Timer timer = new Timer(1000, e -> updateTime());
		timer.start();
	}
	
	private void updateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		timeLabel.setText(sdf.format(date));
		
		Random random = new Random();
		int red = random.nextInt(256);
		int green = random.nextInt(256);
		int blue = random.nextInt(256);
		timeLabel.setForeground(new Color(red, green, blue));
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			DigitalClock clock = new DigitalClock();
			clock.setVisible(true);
		});
	}
}
