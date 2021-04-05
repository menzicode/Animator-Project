
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import model.Circle;
import model.IModel;
import model.IModelImpl;
import model.Oval;
import model.Rectangle;
import model.Shape;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class IModelImplTest {
  IModel t;
  Shape c;
  Shape r;
  Shape o;

  /**
   * Tests the addShape() method.
   */
  @Test
  public void testAddShape() {
    IModel t = new IModelImpl();
    Shape c = new Circle(3, 1, 2, 100, 100, 100,
            0, 100, "First Circle");
    Shape r = new Rectangle(2, 3, 1, 1,
            200, 200, 200,
            20, 50, "First Rectangle");
    Shape o = new Oval(10.5, 5.3, 100.0, 800, 0,
            0,100,10, 20,"First Oval");
    t.addShape(c);
    t.addShape(r);
    t.addShape(o);
    assertEquals(3, t.getShapeCount());
  }

  /**
   * Test IllegalArgumentException for addShape() method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgAddShape() {
    IModel t = new IModelImpl();
    Shape c = new Circle(3, 1, 2, 100, 100, 100,
            0, 100, "First Circle");
    t.addShape(c);
    t.addShape(c);
  }

  /**
   * Tests the removeShape() method.
   */
  @Test
  public void testRemoveShape() {
    IModel t = new IModelImpl();
    Shape c = new Circle(3, 1, 2, 100, 100, 100,
            0, 100, "First Circle");
    Shape r = new Rectangle(2, 3, 1, 1,
            200, 200, 200,
            20, 50, "First Rectangle");
    Shape o = new Oval(10.5, 5.3, 100.0, 800, 0,
            0,100,10, 20,"First Oval");
    t.addShape(c);
    t.addShape(r);
    t.addShape(o);
    t.removeShape(o);
    assertEquals(2, t.getShapeCount());
  }

  /**
   * Tests the NoSuchElementException in removeShape() method.
   */
  @Test
  public void testNoSuchElementRemoveShape() {
    try {
      IModel model = new IModelImpl();
      Shape r = new Rectangle(2, 3, 1, 1,
              200, 200, 200,
              20, 50, "First Rectangle");
      Shape o = new Oval(10.5, 5.3, 100.0, 800, 0,
              0, 100, 10, 20, "First Oval");
      model.addShape(o);
      model.removeShape(r);
    } catch (NoSuchElementException e) {
      IModel model = new IModelImpl();
      assertEquals(0, model.getShapeCount());
    }
    try {
      IModel model = new IModelImpl();
      Shape r = new Rectangle(2, 3, 1, 1,
              200, 200, 200,
              20, 50, "First Rectangle");
      model.removeShape(r);
    } catch (NoSuchElementException e) {
      IModel model = new IModelImpl();
      assertEquals(0, model.getShapeCount());
    }
  }

  /**
   * Tests the getSpecificShape() method.
   */
  @Test
  public void testGetSpecificShape() {
    IModel t = new IModelImpl();
    Shape c = new Circle(3, 1, 2, 100, 100, 100,
            0, 100, "First Circle");
    Shape r = new Rectangle(2, 3, 1, 1,
            200, 200, 200,
            20, 50, "First Rectangle");
    Shape o = new Oval(10.5, 5.3, 100.0, 800, 0,
            0,100,10, 20,"First Oval");
    t.addShape(c);
    t.addShape(r);
    t.addShape(o);
    assertEquals(r, t.getSpecificShape(r));
  }

  /**
   * Tests NoSuchElementException in getSpecificShape() method.
   */
  @Test(expected = NoSuchElementException.class)
  public void testNoSuchElementGetSpecificShape() {
    IModel t = new IModelImpl();
    Shape c = new Circle(3, 1, 2, 100, 100, 100,
            0, 100, "First Circle");
    t.getSpecificShape(c);
  }


  @Test
  public void testToString() {
  }

  /**
   * Tests the getShapeCount() method.
   */
  @Test
  public void getShapeCount() {
    IModel t = new IModelImpl();
    Shape c = new Circle(3, 1, 2, 100, 100, 100,
            0, 100, "First Circle");
    t.addShape(c);
    assertEquals(1, t.getShapeCount());
    t.removeShape(c);
    assertEquals(0, t.getShapeCount());
  }
}