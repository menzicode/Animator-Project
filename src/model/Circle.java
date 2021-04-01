package model;


/**
 * This class represents a circle.  It offers all the operations mandated by the model.Shape interface.
 */
public class Circle extends AbstractShape {
  protected double radius;

  /**
   * Constructs a model. Circle with a given center, radius, color, time of appearance and disappearance,
   * name, and shapeType. An IllegalArgumentException is thrown for radius size less than zero.
   * @param radius the radius of the circle
   * @param reference Point2D object that represents a positive x,y start coordinate
   * @param color Color object that represents the color of the shape
   * @param time Ticker object that represents the appearance and disappearance time
   * @param name string name of the shape
   * @param shapeType string type of shape
   * @throws IllegalArgumentException for radius less than zero
   */
  public Circle(double radius, Point2D reference, Color color, Ticker time, String name,
                String shapeType) {
    super(reference, color, time, name, shapeType);
    if (radius < 0) {
      throw new IllegalArgumentException("Radius can't be negative size!");
    }
    this.radius = radius;
  }

  /**
   * Returns the radius of the circle.
   * @return radius
   */
  public double getRadius() {
    return this.radius;
  }

  @Override
  public double area() {
    return Math.PI * radius * radius;
  }

  @Override
  public double perimeter() {
    return 2 * Math.PI * radius;
  }

  /**
   * Transforms the circle by giving it a new radius value. An IllegalArgumentException is thrown
   * if the radius is equal to the original value or if it's less than zero.
   * @param radius new radius value
   * @throws IllegalArgumentException if the radius is equal to the original value or if it's
   * less than zero
   */
  public void transform(double radius) {
    if (radius < 0 || this.radius == radius) {
      throw new IllegalArgumentException("Radius must be positive and different value than original" +
              "radius size!");
    }
    this.radius = radius;
  }


  public String toString() {
    return String.format("model.Circle: center (%.3f,%.3f) radius %.3f",
            this.reference.getX(), this.reference.getY(), this.radius);
  }

  @Override
  public int compareTo(Shape o) {
    return 0;
  }
}