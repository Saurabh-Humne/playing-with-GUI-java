import javax.swing.*;
public class Code01JButton {

 public static void main(String[] args){
  JFrame f = new JFrame();
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  JButton b = new JButton("click");
  b.setBounds(100,100,100,40);

  f.add(b);
  f.setSize(400,500);
  f.setLayout(null);
  f.setVisible(true);
 }
}
