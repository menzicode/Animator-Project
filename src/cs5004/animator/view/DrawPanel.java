package cs5004.animator.view;

import java.awt.*;
import java.awt.geom.Point2D;

import javax.swing.*;

public class DrawPanel extends JPanel {
  private Point2D shapePosition;

  public DrawPanel(){
    super();
    this.setBackground(Color.WHITE);

  }

  @Override
  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    g2d.setColor(Color.BLACK);
  }
}
