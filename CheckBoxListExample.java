import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxListExample extends JFrame {

	private JCheckBox[] checkBoxes;
	
	public CheckBoxListExample() {
		setTitle("checkbox LIst Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] item = {"Item 1", "Item 2", "Item 3", "Item 4", "Item"};
		
		JPanel panel = new JPanel(new GridLayout(item.length, 1));
		checkBoxes = new JCheckBox[item.length];
		
		for( int i = 0; i < item.length; i++) {
			checkBoxes[i] = new JCheckBox(item[i]);
			panel.add(checkBoxes[i]);
		}
		
		getContentPane().add(panel);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CheckBoxListExample();
			}
		});
	}
}
