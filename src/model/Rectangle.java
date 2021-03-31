package model;


/**
 * This class represents a rectangle.  It defines all the operations mandated by
 * the model.Shape interface
 */
public class Rectangle extends AbstractShape {
  private double width, height;

  /**
   * Constructs a rectangle object with the given location of it's upper-left
   * corner and dimensions. An IllegalArgumentException is thrown for width or height values less
   * than zero.
   * @param x      x coordinate of the lower-left corner of this rectangle
   * @param y      y coordinate of the lower-left corner of this rectangle
   * @param width  width of this rectangle
   * @param height height of this rectangle
   * @param red the int representing the red of a model.Color
   * @param green the int representing the green of a model.Color
   * @param blue the int representing the blue of a model.Color
   * @param appears the int time at which the shape appears
   * @param disappears the int time at which the shape disappears
   * @param name string representation of the name to call the shape
   * @param shapeType string representation of the type of shape
   * @throws IllegalArgumentException for width or height less than zero
   */
  public Rectangle(double x, double y, double width, double height, int red, int green, int blue,
         int appears, int disappears, String name, String shapeType) {
    super(new Point2D(x, y), new Color(red, green, blue), new Ticker(appears,
            disappears), name, shapeType);
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Width and height must be positive!");
    }
    this.width = width;
    this.height = height;
  }

  @Override
  public double area() {
    return this.width * this.height;
  }

  @Override
  public double perimeter() {
    return 2 * (this.width + this.height);
  }

  @Override
  public void changeColor(int red, int green, int blue) {

  }

  public Shape transform(double width, double height) {
    if (width < 0 || height < 0 || (this.width == width && this.height == height)) {
      throw new IllegalArgumentException("Width and height must be positive and not the same as" +
              "original values!");
    }
    this.width = width;
    this.height = height;
    return this;
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