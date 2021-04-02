package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class IModelImplTest {
  IModel t = new IModelImpl();
  Shape c = new Circle(3, 1,2, 100,100,100,
          0, 100, "First Circle");
  Shape r = new Rectangle(2, 3, 1, 1,
          200, 200, 200,
          20, 50, "First Rectangle");

  @Test
  public void addShape() {
    t.addShape(c);
  }

  @Test
  public void removeShape() {
  }

  @Test
  public void getSpecificShape() {
  }

  @Test
  public void testToString() {
  }

  @Test
  public void getShapesAtTicker() {
  }

  @Test
  public void getShapeCount() {
  }
}