import javax.swing.*;

public class InputDisplayGUI extends JFrame {
  public InputDisplayGUI() {
    setTitle("Input Display");
    setSize(300, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();

    JLabel label = new JLabel("Enter your input: ");

    JTextField textField = new JTextField(20);

    JButton displayButton = new JButton("display Input");

    displayButton.addActionListener(e -> {
      String userInput = textField.getText();
      JOptionPane.showMessageDialog(this, "You entered: "+ userInput);
    });

    panel.add(label);
    panel.add(textField);
    panel.add(displayButton);

    setContentPane(panel);
  }

  public static void main(String[] args){
    SwingUtilities.invokeLater(() -> {
      InputDisplayGUI inputDisplayGUI = new InputDisplayGUI();
      inputDisplayGUI.setVisible(true);
    });
  }
}
