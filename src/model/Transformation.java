package model;

/**
 * Class used to represent transformation of a specific shape.
 */
public class Transformation {

  protected double newWidth;
  protected double newHeight;
  protected double radiusX;
  protected double radiusY;
  protected double radius;
  protected Point2D startLocation;
  protected Point2D endLocation;
  protected Color startColor;
  protected Color endColor;
  protected Ticker colorChangePeriod;
  protected Ticker sizeChangePeriod;

  /**
   * Constructs a transformed circle. The size of the radius is transformed from its original state.
   *
   * @param startLocation     beginning transition coordinate.
   * @param endLocation       end of transition coordinate.
   * @param sizeChangePeriod  denotes time size transformation happens.
   * @param startColor        the starting color of shape.
   * @param endColor          ending color of shape.
   * @param colorChangePeriod denotes time color transformation happens.
   */
  public Transformation(Point2D startLocation, Point2D endLocation, Ticker sizeChangePeriod,
                        Color startColor, Color endColor, Ticker colorChangePeriod) {
    this.startLocation = startLocation;
    this.endLocation = endLocation;
    this.startColor = startColor;
    this.endColor = endColor;
    this.sizeChangePeriod = sizeChangePeriod;
    this.colorChangePeriod = colorChangePeriod;
  }

  /**
   * Constructs a transformed rectangle. Rectangle has new values for fields.
   * @param newHeight         the new height for the rectangle.
   * @param newWidth          the new width for the rectangle.
   * @param startLocation     beginning transition coordinate.
   * @param endLocation       end of transition coordinate.
   * @param sizeChangePeriod  denotes time size transformation happens.
   * @param startColor        the starting color of shape.
   * @param endColor          ending color of shape.
   * @param colorChangePeriod denotes time color transformation happens.
   */
  public Transformation(double newHeight, double newWidth, Point2D startLocation, Point2D endLocation,
                            Ticker sizeChangePeriod, Color startColor, Color endColor,
                            Ticker colorChangePeriod) {
    if (newWidth < 0 || newHeight < 0 ) {
      throw new IllegalArgumentException("Width and height must be positive and not the same as" +
              "original values!");
    }
    this.newHeight = newHeight;
    this.newWidth = newWidth;
    this.startLocation = startLocation;
    this.endLocation = endLocation;
    this.startColor = startColor;
    this.endColor = endColor;
    this.sizeChangePeriod = sizeChangePeriod;
    this.colorChangePeriod = colorChangePeriod;
  }

  /**
   * Transform Constructor for Oval Transformation.
   * @param startLocation
   * @param endLocation
   * @param sizeChangePeriod
   * @param startColor
   * @param endColor
   * @param colorChangePeriod
   * @param radiusX
   * @param radiusY
   */
  public Transformation(Point2D startLocation, Point2D endLocation,
                        Ticker sizeChangePeriod, Color startColor, Color endColor,
                        Ticker colorChangePeriod, double radiusX, double radiusY) {
    if (radiusX < 0 || radiusY < 0 ) {
      throw new IllegalArgumentException("Width and height must be positive and not the same as" +
              "original values!");
    }
    this.radiusX = radiusX;
    this.radiusY = radiusY;
    this.startLocation = startLocation;
    this.endLocation = endLocation;
    this.startColor = startColor;
    this.endColor = endColor;
    this.sizeChangePeriod = sizeChangePeriod;
    this.colorChangePeriod = colorChangePeriod;
  }

  /**
   * Gets the start x coordinate point where the shape's transformation begins.
   * @return x coordinate x coordinate of shape at start of transformation.
   */
  public double getStartXCoordinate() {
    return this.startLocation.x;
  }

  /**
   * Gets the start y coordinate point where the shape's transformation begins.
   * @return y coordinate y coordinate of shape at end of transformation.
   */
  public double getStartYCoordinate() {
    return this.startLocation.y;
  }

  /**
   * Gets the end x coordinate point for the shape's transformation.
   * @return x coordinate x coordinate of shape at end of transformation.
   */
  public double getEndXCoordinate() {
    return this.endLocation.x;
  }

  /**
   * Gets the end y coordinate point for the shape's transformation.
   * @return y coordinate y coordinate of shape at end of transformation.
   */
  public double getEndYCoordinate() {
    return this.endLocation.y;
  }

  /**
   * Gets the start time of the transformation change.
   * @return start time of the transformation
   */
  public int getStartTime() {
    return this.sizeChangePeriod.getRangeStart();
  }

  /**
   * Gets the end time of the transformation change.
   * @return end time of the transformation change
   */
  public int getEndTime() {
    return this.sizeChangePeriod.getRangeEnd();
  }

  /**
   * Gets the start color of the shape.
   * @return color of the shape to start, all three rbg values
   */
  public Color getStartColor() {
    return this.startColor;
  }

  /**
   * Gets the end color of the shape.
   * @return color the shape ends with, all three rbg values.
   */
  public Color getEndColor() {
    return this.endColor;
  }
  /**
   * Gets the start time of the color change.
   * @return start time of the color transformation.
   */
  public int getColorStartTime() {
    return this.colorChangePeriod.getRangeStart();
  }

  /**
   * Gets the end time of the color change.
   * @return end time of the color transformation.
   */
  public int getColorEndTime() {
    return this.colorChangePeriod.getRangeEnd();
  }

  /**
   * Creates a string version of the transformation.
   *
   * @return string description of transformation.
   */

  @Override
  public String toString() {
    String string = "";
    if (this.endLocation != null) {
      string = String.format("moves from (%.3f,%.3f) to (%.3f,%.3f) from t=%d to t=%d\n",
              startLocation.getX(), startLocation.getY(), endLocation.getX(), endLocation.getY(),
              sizeChangePeriod.getRangeStart(),
              sizeChangePeriod.getRangeEnd());
    }

    if (this.endColor != null) {
      string = string + String.format("Changes color from (%.1d, %.1d, %.1d) to " +
                      "(%.1d, %.1d, %.1d) from t=%d to t=%d",
              startColor.red, startColor.green, startColor.blue, endColor.red,
              endColor.green, endColor.blue,
              sizeChangePeriod.getRangeStart(),
              sizeChangePeriod.getRangeEnd());
    }
    return string;
  }
}
