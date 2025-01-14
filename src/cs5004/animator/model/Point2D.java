package cs5004.animator.model;

/**
 * This class represents a 2D point. This point is denoted in Cartesian coordinates as (x,y).
 */
public class Point2D {
  protected double x;
  protected double y;

  /**
   * Construct a 2d point with the given coordinates.
   *
   * @param x the x-coordinate of this point
   * @param y the y-coordinate of this point
   * @throws IllegalArgumentException if coordinate values are less than zero.
   */
  public Point2D(double x, double y) throws IllegalArgumentException {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("Parameters for coordinates may not be negative");
    }
    this.x = x;
    this.y = y;
  }

  /**
   * Compute and return the Euclidean distance of this point to the origin.
   *
   * @return the euclidean distance.
   */

  public double distToOrigin() {
    return Math.sqrt(x * x + y * y);
  }

  /**
   * Return the x-coordinate of this point.
   *
   * @return x-coordinate of this point.
   */
  public double getX() {
    return x;
  }

  /**
   * Return the y-coordinate of this point.
   *
   * @return y-coordinate of this point.
   */
  public double getY() {
    return y;
  }

  /**
   * Sets the x and y parameter of this point.
   *
   * @param x x-coordinate of this point.
   * @param y y-coordinate of this point.
   */
  public void setXandY(double x, double y) {
    this.x = x;
    this.y = y;
  }
}