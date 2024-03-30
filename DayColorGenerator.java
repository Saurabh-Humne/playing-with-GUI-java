import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class DayColorGenerator extends JFrame {
	
	private JLabel colorLabel;
	
	public DayColorGenerator() {
		setTitle("Day Color Generator");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		colorLabel = new JLabel();
		colorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		updateColor();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(colorLabel, BorderLayout.CENTER);
	}
	
	private void updateColor() {
		Date today = new Date();
		Color color = getColorByDay(today);
		colorLabel.setBackground(color);
		colorLabel.setOpaque(true);
		colorLabel.setText("Color of the Day" + getColorName(color));
	}
	
	private Color getColorByDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		switch (dayOfWeek) {
		case Calendar.SUNDAY:
			return Color.RED;
		case Calendar.MONDAY:
			return Color.BLUE;
		case Calendar.TUESDAY:
			return Color.GREEN;
		case Calendar.WEDNESDAY:
			return Color.YELLOW;
		case Calendar.THURSDAY:
			return Color.ORANGE;
		case Calendar.FRIDAY:
			return Color.MAGENTA;
		case Calendar.SATURDAY:
			return Color.CYAN;
		default:
			return Color.WHITE;
		}
	}
	
	private String getColorName(Color color) {
		if (color.equals(color.RED)) return "RED";
		if (color.equals(color.BLUE)) return "BLUE";
		if (color.equals(color.GREEN)) return "GREEN";
		if (color.equals(color.YELLOW)) return "YELLOW";
		if (color.equals(color.ORANGE)) return "ORANGE";
		if (color.equals(color.MAGENTA)) return "MAGENTA";
		if (color.equals(color.CYAN)) return "CYAN";
		return "Unknown";
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() ->{
			DayColorGenerator gui = new DayColorGenerator();
			gui.setVisible(true);
		});
	}
}
