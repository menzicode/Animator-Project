

/**
 * Abstract Class for Shape Class.
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
  public double distanceFromOrigin() {
    return reference.distToOrigin();
  }

}