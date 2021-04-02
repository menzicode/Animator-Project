package model;

/**
 * Class used to represent Oval shape.
 */
public class Oval extends AbstractShape {
  double radiusX;
  double radiusY;

  /**
   * Constructor for an Oval shape.
   *
   * @param radiusX          size of X radius.
   * @param radiusY          size of y radius.
   * @param startXCoordinate The x coordinate the object will originally be located.
   * @param startYCoordinate The y coordinate the object will originally be located.
   * @param red              Red value for color of shape.
   * @param green            Green value for color of shape.
   * @param blue             Blue value for color of shape.
   * @param timeAppears      The time the object is set to appear on the display.
   * @param timeDisappears   The time the object is set to disappear on the display.
   * @param name             string name of the shape
   */
  public Oval(double radiusX, double radiusY, double startXCoordinate, double startYCoordinate,
              int red, int green, int blue, int timeAppears, int timeDisappears, String name) {
    super(startXCoordinate, startYCoordinate, red, green, blue, timeAppears, timeDisappears, name);

    this.radiusX = radiusX;
    this.radiusY = radiusY;
    this.shapeType = ShapeType.OVAL;
  }

  @Override
  public int getRed() {
    return 0;
  }

  @Override
  public int getGreen() {
    return 0;
  }

  @Override
  public int getBlue() {
    return 0;
  }

  @Override
  public double area() {
    return radiusX * radiusY * Math.PI;
  }

  @Override
  public double perimeter() {
    return 2 * Math.PI * Math.sqrt((radiusX * radiusX + radiusY * radiusY) / 2);
  }

  @Override
  public int compareTo(Shape o) {
    return 0;
  }
}
