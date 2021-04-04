package model;


/**
 * This class represents a circle.  It offers all the operations mandated by the model.Shape
 * interface.
 */
public class Circle extends AbstractShape {
  protected double radius;

  /**
   * Constructs a model. Circle with a given center, radius, color, time of appearance and
   * disappearance, name, and shapeType. An IllegalArgumentException is thrown for radius size less
   * than zero.
   *
   * @param radius           the radius of the circle
   * @param startXCoordinate The x coordinate the object will originally be located.
   * @param startYCoordinate The y coordinate the object will originally be located.
   * @param red              Red value for color of shape.
   * @param green            Green value for color of shape.
   * @param blue             Blue value for color of shape.
   * @param timeAppears      The time the object is set to appear on the display.
   * @param timeDisappears   The time the object is set to disappear on the display.
   * @param name             string name of the shape
   * @throws IllegalArgumentException for radius less than zero
   */
  public Circle(double radius, double startXCoordinate, double startYCoordinate, int red,
                int green, int blue,
                int timeAppears, int timeDisappears,
                String name) {
    super(startXCoordinate, startYCoordinate, red, green, blue, timeAppears, timeDisappears, name);
    if (radius < 0) {
      throw new IllegalArgumentException("Radius can't be negative size!");
    }
    this.radius = radius;
    super.shapeType = ShapeType.CIRCLE;
  }

  /**
   * Returns the radius of the circle.
   *
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
   * Creates a transformation that changes the circle's size. An IllegalArgumentException is thrown
   * if the radius is equal to the original value or if it's less than zero.
   *
   * @param newRadius new radius value.
   * @param timeStart Start interval of the transformation.
   * @param timeEnd   End interval of the transformation.
   * @throws IllegalArgumentException if the radius is equal to the original value or if it's less
   *                                  than zero
   */

  public void changeSize(double newRadius, int timeStart, int timeEnd) {
    if (radius < 0 || this.radius == radius) {
      throw new IllegalArgumentException("Radius must be positive and different value than original" +
              "radius size!");
    }
    Transformation sizeTransformation = new Transformation(null, null,
            new Ticker(timeStart, timeEnd), null, null,
            null, newRadius);

    this.transformationList.add(sizeTransformation);
  }

  @Override
  public void changeColor(int red, int green, int blue, int timeStart, int timeEnd) {
    super.changeColor(red, green, blue, timeStart, timeEnd);
  }

  @Override
  public void move(double newX, double newY, int timeStart, int timeEnd) {
    super.move(newX, newY, timeStart, timeEnd);
  }

  public String toString() {
    return String.format("model.Circle: center (%.3f,%.3f) radius %.3f",
            this.reference.getX(), this.reference.getY(), this.radius);
  }

  /*
  Began implementation of compare to for Shape using shape type and shape name as parameters.
  will further iron out necessary comparisons for compare.
   */
  @Override
  public int compareTo(Shape o) {
    if (this.shapeType == o.getShapeType() && this.name.equals(o.getName())) {

    }
    return 0;
  }
}