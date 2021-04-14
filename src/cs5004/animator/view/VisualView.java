package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VisualView extends JFrame implements IView {
  private JButton commandButton, quitButton;
  private JPanel buttonPanel;
  private DrawPanel drawPanel;
  private JTextField input;
  private JLabel display;


  public VisualView() {
    super();
    this.setTitle("ModelAnimator!");
    this.setSize(500, 500);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    this.setLayout(new BorderLayout());
    drawPanel = new DrawPanel();
    drawPanel.setPreferredSize(500,500);
    this.add(drawPanel, BorderLayout.CENTER);

    buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    this.add(buttonPanel, BorderLayout.SOUTH);

    input = new JTextField(15);
    buttonPanel.add(input);

    commandButton = new JButton("Execute Operation");
  }

  @Override
  public void makeVisible() {

  }

  @Override
  public void setCommandButtonListener(ActionListener actionEvent) {

  }

  @Override
  public void showErrorMessage(String error) {

  }

  @Override
  public void refresh() {

  }

  @Override
  public void setShapes() {

  }

  @Override
  public void setText() {

  }
}
