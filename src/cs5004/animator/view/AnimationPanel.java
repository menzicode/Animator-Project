package cs5004.animator.view;

import java.awt.*;

import javax.swing.*;

public class AnimationPanel extends JPanel {
  public AnimationPanel() {
    super();
    this.add(this, BoxLayout.PAGE_AXIS);
  }
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
  }
}
