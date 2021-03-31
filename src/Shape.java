/**
 * This interface contains all operations that all types of shapes
 * should support.
 */
public interface Shape extends Comparable<Shape>{

  /**
   * Returns the distance of this shape from the origin. The distance is
   * measured from whatever reference position a shape is (e.g. a center for
   * a circle)
   * @return the distance from the origin
   */
  double distanceFromOrigin();
  /**
   * Computes and returns the area of this shape.
   * @return the area of the shape
   */
  double area();

  /**
   * Computes and returns the perimeter of this shape.
   * @return the perimeter of the shape
   */
  double perimeter();

  /**
   * Changes the color of the shape by adjusting the integer values of red, green and blue. Throws
   * an IllegalArgumentException when the integer values are less than zero or greater than 255.
   * @param red the int value of the red color
   * @param green the int value of the green color
   * @param blue the int value of the blue color
   * @throws IllegalArgumentException when colors are less than zero or greater than 255
   */
  void changeColor(int red, int green, int blue);
}