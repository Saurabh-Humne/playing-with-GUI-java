import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch extends JFrame {
	
	private Timer timer;
	private int seconds = 0;
	private JLabel timeLabel;
	
	public Stopwatch() {
		setTitle("Stopwatch");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		timeLabel = new JLabel("00:00:00");
		timeLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		
		JButton startButton = new JButton("Start");
		JButton stopButton = new JButton("Stop");
		JButton resetButton = new JButton("Reset");
		
		startButton.addActionListener(e -> start());
		stopButton.addActionListener(e -> stop());
		resetButton.addActionListener(e -> reset());
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(resetButton);
		
		add(timeLabel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void start() {
		if (timer == null) {
			timer = new Timer(1000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					seconds++;
					updateDisplay();
				}
				
			});
			timer.start();
		}
	}
	
	private void stop() {
		if (timer != null) {
			timer.stop();
		}
	}
	
	private void reset() {
		stop();
		seconds = 0;
		updateDisplay();
	}
	
	private void updateDisplay() {
		int hours = seconds / 3600;
		int minutes = (seconds % 3600) / 60;
		int secs = seconds % 60;
		
		String time = String.format("%02d:%02d:%02d", hours, minutes, secs);
		timeLabel.setText(time);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Stopwatch());
	}
}
