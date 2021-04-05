package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

/**
 * This class represents the model for an animation with shapes. The class implements all methods
 * from the model.IModel interface.
 */
public class IModelImpl implements IModel {
  protected ArrayList<Shape> shapes;
  protected int shapeCount;

  /**
   * Constructs an animation model that starts with an empty animation screen.
   */
  public IModelImpl() {
    this.shapes = new ArrayList<>();
    this.shapeCount = 0;
  }

  @Override
  public void addShape(Shape object) {
    if (shapes.contains(object)) {
        throw new IllegalArgumentException("This shape already exists.");
    }
    shapes.add(object);
    shapeCount++;
  }

  @Override
  public void removeShape(Shape object) {
    if (!shapes.contains(object)) {
        throw new NoSuchElementException("This shape is not in the animation.");
    }
    shapes.remove(object);
    shapeCount--;
  }

  @Override
  public Shape getSpecificShape(Shape object) {
    if (!shapes.contains(object)) {
      throw new NoSuchElementException("This shape is not in the animation.");
    }
    return object;
  }

  @Override
  public void sort(ShapeTimeComparator comp) {
    Collections.sort(shapes, new ShapeTimeComparator());
  }

  @Override
  public String toString() {
    Collections.sort(shapes, new ShapeTimeComparator());
    StringBuilder str = new StringBuilder("Shapes:\n");
    for (Shape object : shapes) {
      str.append("Name: ").append(object.getName()).append("\n");
      str.append("Type: ").append(object.getShapeType()).append("\n");
      if (object.getShapeType().equals(AbstractShape.ShapeType.RECTANGLE)) {
        str.append("Min corner: ");
        str.append("(" + object.getX() + "," + object.getY() + ")" + ", ");
        str.append("Width: ");
        str.append(Rectangle.width).append(", Height: ").append(Rectangle.height).append(",\n");
      } else if (object.getShapeType().equals(AbstractShape.ShapeType.CIRCLE)) {
        str.append("Center: ");
        str.append("(" + object.getX() + "," + object.getY() + ",").append("Radius: ");
        str.append(Circle.radius).append(",\n");
      } else if (object.getShapeType().equals(AbstractShape.ShapeType.OVAL)) {
        str.append("Center: ");
        str.append("(" + object.getX() + "," + object.getY() + ",").append("X radius: ");
        str.append(Oval.radiusX).append(", Y radius: ").append(Oval.radiusY).append(",\n");
      }
        str.append("Color: ");
        str.append("(" + object.getRed() + "," + object.getGreen() + "," + object.getBlue());
        str.append(")\n");
        str.append("Appears at t=" + object.getAppearance() +"\n");
        str.append("Disappears at t=" + object.getDisappearance() + "\n");
    }
    return str.toString();
  }

  @Override
  public ArrayList<Shape> getShapesAtTicker(int ticker) {
    return null; //To be implemented in later weeks
  }

  public int getShapeCount() {
    return shapes.size();
  }
}
