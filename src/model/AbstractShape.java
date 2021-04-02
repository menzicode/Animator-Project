package model;

/**
 * Abstract Class for model.Shape Class.
 */
public abstract class AbstractShape implements Shape {
  protected Point2D reference;
  protected Color color;
  protected Ticker time;
  protected String name;
  protected ShapeType shapeType;
  protected Transformation transformation;

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
  public Color getColor() {
    return this.color;
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

  /**
   * Used to store the parameters for a shape's transformation.
   *
   * @param finalXCoordinate     final x coordinate of shape as a double.
   * @param finalYCoordinate     final y coordinate of shape as a double.
   * @param sizeChangeStartTime  time interval where size transformation begins.
   * @param sizeChangeEndTime    time interval where size transformation ends.
   * @param newColorRed          integer value of new color's red parameter.
   * @param newColorGreen        integer value of new color's green parameter.
   * @param newColorBlue         integer value of new color's blue parameter.
   * @param colorChangeStartTime time interval where color transformation begins.
   * @param colorChangeEndTime   time interval where color transformation ends.
   */
  /* Invalid arguments are handled during the construction of each type*/
  public void setTransformation(double finalXCoordinate, double finalYCoordinate,
                                int sizeChangeStartTime, int sizeChangeEndTime,
                                int newColorRed, int newColorGreen, int newColorBlue,
                                int colorChangeStartTime, int colorChangeEndTime) {

    this.transformation = new Transformation(this.reference,
            new Point2D(finalXCoordinate, finalYCoordinate),
            new Ticker(sizeChangeStartTime, sizeChangeEndTime), this.color,
            new Color(newColorRed, newColorGreen, newColorBlue),
            new Ticker(colorChangeStartTime, colorChangeEndTime));

  }

  @Override
  public void changeColor(int red, int green, int blue) {
    if (red < 0 || green < 0 || blue < 0 || (this.color.red == red && this.color.green == green
            && this.color.blue == blue)) {
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
    this.newLocation = newLocation;

  }

}