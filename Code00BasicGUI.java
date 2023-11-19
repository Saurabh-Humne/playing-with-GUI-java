import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Code00BasicGUI {
 public static void main(String[] args){
  
  JFrame frame = new JFrame();
  frame.setTitle("First GUI");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setResizable(false);
  frame.setSize(500,500);
  frame.setVisible(true);

  // imageIcon img = new ImageIcon("Img.png"); // put image over here
  // frame.setIconImage(img.getImg());
  frame.getContentPane().setBackground(new Color(100,150,150));
 }
}