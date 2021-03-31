import java.util.ArrayList;

public interface IModel {


  /**
   * Remove shape.
   */
  void removeShape();

  /**
   * Returns specific shape.
   */
  Shape getSpecificShape();

  /**
   * Adds a shape.
   */
  void addShape();


  /**
   * Returns a collection of copy of shapes at specific time.
   * @param ticker instance of time
   */
  ArrayList<Shape> getShapesAtTicker(int ticker);
}
