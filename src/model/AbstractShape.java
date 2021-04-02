package model;

import java.util.ArrayList;

/**
 * Abstract Class for model.Shape Class.
 */
public abstract class AbstractShape implements Shape {
  protected Point2D reference;
  protected Color color;
  protected Ticker time;
  protected String name;
  protected ShapeType shapeType;
  protected ArrayList<Transformation> transformationList;

  /**
   * Enum class used to identify Shape type for concrete instances of AbstractShape.
   */
  protected enum ShapeType {
    CIRCLE, RECTANGLE, OVAL;

    /**
     * Method for enum class used to represent enum as a string.
     *
     * @return String representation of ShapeType.
     */
    @Override
    public String toString() {
      String symbol;
      switch (this) {
        case CIRCLE:
          symbol = "Circle";
          break;
        case RECTANGLE:
          symbol = "Rectangle";
          break;
        case OVAL:
          symbol = "Oval";
          break;
        default:
          throw new IllegalArgumentException("Shape Type is invalid");
      }
      return symbol;
    }
  }
  /**
   * Constructs an Abstract shape with a given reference point, color, time, name.
   *
   * @param startXCoordinate The x coordinate the object will originally be located.
   * @param startYCoordinate The y coordinate the object will originally be located.
   * @param red              Red value for color of shape.
   * @param green            Green value for color of shape.
   * @param blue             Blue value for color of shape.
   * @param timeAppears      The time the object is set to appear on the display.
   * @param timeDisappears   The time the object is set to disappear on the display.
   * @param name             string name of the shape
   */
  public AbstractShape(double startXCoordinate, double startYCoordinate,
                       int red, int green, int blue, int timeAppears, int timeDisappears,
                       String name) {
    this.reference = new Point2D(startXCoordinate, startYCoordinate);
    this.color = new Color(red, green, blue);
    this.time = new Ticker(timeAppears, timeDisappears);
    this.name = name;
  }

  @Override
  public double getX() {
    return this.reference.x;
  }

  @Override
  public double getY() {
    return this.reference.y;
  }

  @Override
  public int getRed() {
    return this.color.red;
  }

  @Override
  public int getGreen() {
    return this.color.green;
  }

  @Override
  public int getBlue() {
    return this.color.blue;
  }

  @Override
  public int getAppearance() {
    return this.time.getRangeStart();
  }

  @Override
  public int getDisappearance() {
    return this.time.getRangeEnd();
  }

  @Override
  public String getName() {
    return this.name;
  }


  public ShapeType getShapeType() {
    return this.shapeType;
  }

  @Override
  public double distanceFromOrigin() {
    return reference.distToOrigin();
  }

  @Override
  public void changeColor(int red, int green, int blue, int timeStart, int timeEnd) {
    if (this.color.red == red && this.color.green == green
            && this.color.blue == blue) {
      throw new IllegalArgumentException("Color values can't be less than zero or all the same as" +
              "original values.");
    }
    this.color.red = red;
    this.color.green = green;
    this.color.blue = blue;
  }

  @Override
  public void move(Point2D newLocation, Ticker time) {
    if (newLocation.x < 0 || newLocation.y < 0 || (this.reference == newLocation)
            || time.getRangeStart() < this.time.getRangeStart() || time.getRangeEnd() <= time.getRangeStart()) {
      throw new IllegalArgumentException("Invalid location or time period for movement.");
    }


  }

}