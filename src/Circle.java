
/**
 * This class represents a circle.  It offers all the operations mandated by the Shape interface.
 */
public class Circle extends AbstractShape {
  private double radius;

  /**
   * Constructs a Circle with a given center, radius, color, time of appearance and disappearance,
   * name, and shapeType. An IllegalArgumentException is thrown for radius size less than zero.
   * @param x      x coordinate of the center of this circle
   * @param y      y coordinate of the center of this circle
   * @param radius the radius of this circle
   * @param red the int representing the red of a Color
   * @param green the int representing the green of a Color
   * @param blue the int representing the blue of a Color
   * @param appears the int time at which the shape appears
   * @param disappears the int time at which the shape disappears
   * @param name string representation of the name to call the shape
   * @param shapeType string representation of the type of shape
   * @throws IllegalArgumentException for radius less than zero
   */
  public Circle(double x, double y, double radius, int red, int green, int blue, int appears, int
                disappears, String name, String shapeType) {
    super(new Point2D(x, y), new Color(red, green, blue), new Ticker(appears,
    disappears), name, shapeType);
    if (radius < 0) {
      throw new IllegalArgumentException("Radius can't be negative size!");
    }
    this.radius = radius;
  }


  @Override
  public double area() {
    return Math.PI * radius * radius;
  }

  @Override
  public double perimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  public void changeColor(int red, int green, int blue) {

  }

  public Shape transform(double radius) {
    if (radius < 0 || this.radius == radius) {
      throw new IllegalArgumentException("Radius must be positive and different value than original" +
              "radius size!");
    }
    this.radius = radius;
    return this;
  }


  public String toString() {
    return String.format("Circle: center (%.3f,%.3f) radius %.3f",
            this.reference.getX(), this.reference.getY(), this.radius);
  }

  @Override
  public int compareTo(Shape o) {
    return 0;
  }
}