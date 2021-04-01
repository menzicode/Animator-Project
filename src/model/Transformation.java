package model;

/**
 * Class used to represent transformation of a specific shape.
 */
public class Transformation {
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

  @Override
  public String toString() {
    return String.format("moves from (%.3f,%.3f) to (%.3f,%.3f) from t=%d to t=%d",
            startLocation.getX(), startLocation.getY(), endLocation.getX(), endLocation.getY(),
            sizeChangePeriod.getRangeStart(),
            sizeChangePeriod.getRangeEnd());
  }
}
