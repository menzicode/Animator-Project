package model;


/**
 * This class represents a rectangle.  It defines all the operations mandated by the model.Shape
 * interface
 */
public class Rectangle extends AbstractShape {
  private double width, height;

  /**
   * Constructs a rectangle object with the given location of it's upper-left corner and dimensions.
   * An IllegalArgumentException is thrown for width or height values less than zero.
   *
   * @param width     width of this rectangle
   * @param height    height of this rectangle
   * @param reference Point2D object that represents a positive x,y start coordinate
   * @param color     Color object that represents the color of the shape
   * @param time      Ticker object that represents the appearance and disappearance time
   * @param name      string name of the shape
   * @throws IllegalArgumentException for width or height less than zero
   */
  public Rectangle(double width, double height, Point2D reference, Color color, Ticker time,
                   String name) {
    super(reference, color, time, name);
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Width and height must be positive!");
    }
    this.width = width;
    this.height = height;
    this.shapeType = ShapeType.RECTANGLE;
  }

  /**
   * Returns the width of the rectangle.
   *
   * @return width
   */
  public double getWidth() {
    return this.width;
  }

  /**
   * Returns the height of the rectangle.
   *
   * @return height
   */
  public double getHeight() {
    return this.height;
  }

  @Override
  public double area() {
    return this.width * this.height;
  }

  @Override
  public double perimeter() {
    return 2 * (this.width + this.height);
  }

  /**
   * Transforms the rectangle by giving it new width and/or height values. An
   * IllegalArgumentException is thrown if the width or height is less than zero or if both values
   * are the same as the original rectangle.
   *
   * @param width  new width of rectangle
   * @param height new height of rectangle
   * @throws IllegalArgumentException if width and height equal original values or either is less
   *                                  than zero
   */
  public void transform(double width, double height) {
    if (width < 0 || height < 0 || (this.width == width && this.height == height)) {
      throw new IllegalArgumentException("Width and height must be positive and not the same as" +
              "original values!");
    }
    this.width = width;
    this.height = height;
  }

  public String toString() {
    return String.format("model.Rectangle: LL corner (%.3f,%.3f) width %.3f height " +
                    "%.3f",
            this.reference.getX(), this.reference.getY(), this.width, this
                    .height);
  }

  @Override
  public int compareTo(Shape o) {
    return 0;
  }
}