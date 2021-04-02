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
   * Constructor for Transformation class.
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
   * Sets the end location point for the shape's transformation.
   *
   * @param xCoordinate x coordinate of shape at end of transformation.
   * @param yCoordinate y coordinate of shape at end of transformation.
   */
  public void setEndLocation(double xCoordinate, double yCoordinate) {
    this.endLocation = new Point2D(xCoordinate, yCoordinate);
  }

  /**
   * Sets the start location point for the shape's transformation.
   *
   * @param xCoordinate x coordinate of shape at beginning of transformation.
   * @param yCoordinate y coordinate of shape at beginning of transformation.
   */
  public void setStartLocation(double xCoordinate, double yCoordinate) {
    this.startLocation = new Point2D(xCoordinate, yCoordinate);
  }

  /**
   * Sets the start color for transformation.
   *
   * @param red   red value of start color.
   * @param green green value of start color.
   * @param blue  blue value of start color.
   */
  public void setStartColor(int red, int green, int blue) {
    this.startColor = new Color(red, green, blue);
  }

  /**
   * Sets the end color for transformation.
   *
   * @param red   red value of end color.
   * @param green green value of end color.
   * @param blue  blue value of end color.
   */
  public void setEndColor(int red, int green, int blue) {
    this.endColor = new Color(red, green, blue);
  }

  /**
   * Sets time interval for when shape goes through size transformation.
   *
   * @param start beginning of size transformation.
   * @param end   end of size transformation.
   */
  public void setSizeChangePeriod(int start, int end) {
    this.sizeChangePeriod = new Ticker(start, end);
  }

  /**
   * Sets time interval for when shape goes through size transformation.
   *
   * @param start beginning time of color transformation.
   * @param end   end time of color transformation.
   */
  public void setColorChangePeriod(int start, int end) {
    this.sizeChangePeriod = new Ticker(start, end);
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
