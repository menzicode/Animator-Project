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
  protected Point2D newLocation;

  /*Enum class added to auto populate shapetype parameter upon construction of concrete instances
  * of AbstractShape. */
  /**
   * Enum class used to identify Shape type for concrete instances of AbstractShape.
   */
  protected enum ShapeType {
    CIRCLE, RECTANGLE;

    /**
     * Method for enum class used to represent enum as a string.
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
   * @param reference Point2D object that represents a positive x,y start coordinate
   * @param color     Color object that represents the color of the shape
   * @param time      Ticker object that represents the appearance and disappearance time
   * @param name      string name of the shape
   */
  public AbstractShape(Point2D reference, Color color, Ticker time, String name) {
    this.reference = reference;
    this.color = color;
    this.time = time;
    this.name = name;
    this.newLocation = null;
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
    return this.time.appears;
  }

  @Override
  public int getDisappearance() {
    return this.time.disappears;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public ShapeType getShapeType() {
    return this.shapeType;
  }

  @Override
  public double distanceFromOrigin() {
    return reference.distToOrigin();
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
            || time.appears < this.time.appears || time.disappears <= time.appears) {
      throw new IllegalArgumentException("Invalid location or time period for movement.");
    }
    this.newLocation = newLocation;

  }

}