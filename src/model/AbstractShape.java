package model;

/**
 * Abstract Class for model.Shape Class.
 */
public abstract class AbstractShape implements Shape {
  protected Point2D reference;
  protected Color color;
  protected Ticker time;
  protected String name;
  protected String shapeType;

  /**
   * Constructs an Abstract shape with a given reference point, color, time, name and shapeType.
   * @param reference Point2D object that represents a positive x,y start coordinate
   * @param color Color object that represents the color of the shape
   * @param time Ticker object that represents the appearance and disappearance time
   * @param name string name of the shape
   * @param shapeType string type of shape
   */
  public AbstractShape(Point2D reference, Color color, Ticker time, String name, String shapeType ) {
    this.reference = reference;
    this.color = color;
    this.time = time;
    this.name = name;
    this.shapeType = shapeType;
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
  public String getShapeType() {
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

}