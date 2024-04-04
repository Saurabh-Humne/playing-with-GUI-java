import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CircleFollowMouse extends JFrame implements MouseMotionListener {
    private int circleX, circleY;
    private final int circleDiameter = 50;

    public CircleFollowMouse() {
        setTitle("Circle Follow Mouse");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        addMouseMotionListener(this);

        // Initially place the circle in the center
        circleX = (getWidth() - circleDiameter) / 2;
        circleY = (getHeight() - circleDiameter) / 2;

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Draw the circle at its current position
        g.setColor(Color.BLUE);
        g.fillOval(circleX, circleY, circleDiameter, circleDiameter);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Not needed for this example
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Update the circle's position to follow the mouse
        circleX = e.getX() - circleDiameter / 2;
        circleY = e.getY() - circleDiameter / 2;
        repaint(); // Redraw the window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CircleFollowMouse());
    }
}
