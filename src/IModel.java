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
   * Changes the color of the shape.
   */
  void changeColor(Shape object);

  /**
   * Changes the size of the shape.
   */
  void transform(Shape object);


  /**
   * Returns a collection of copy of shapes at specific time.
   * @param ticker instance of time
   */
  ArrayList<Shape> getShapesAtTicker(int ticker);
}
