import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements MouseListener {

	JLabel label;
	ImageIcon one;
	ImageIcon two;
	ImageIcon three;
	ImageIcon four;
	
	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(new FlowLayout());
		
		label = new JLabel();
		label.addMouseListener(this);
		
		one = new ImageIcon("01.png");
		two = new ImageIcon("02.png");
		three = new ImageIcon("03.png");
		four = new ImageIcon("04.png");
		
		label.setIcon(one);
		
		this.add(label);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		label.setIcon(three);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		label.setIcon(four);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		label.setIcon(two);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		label.setIcon(one);
		
	}
}
