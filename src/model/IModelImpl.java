package model;

import java.util.ArrayList;

/**
 * This class represents the model for an animation with shapes. The class implements all methods
 * from the model.IModel interface.
 */
public class IModelImpl implements IModel {
  private ArrayList<Shape> shapes;
  private int shapeCount;

  /**
   * Constructs an animation model that starts with an empty animation screen.
   */
  public IModelImpl() {
    this.shapes = new ArrayList<Shape>();
    this.shapeCount = 0;
  }

  @Override
  public void addShape(Shape object) {
    shapes.add(object);
    shapeCount++;
  }

  @Override
  public void removeShape(Shape object) {
    if (!shapes.contains(object)) {
      throw new IllegalArgumentException("This shape is not in the animation.");
    }
    shapes.remove(object);
    shapeCount--;
  }

  @Override
  public Shape getSpecificShape(Shape object) {
    if (!shapes.contains(object)) {
      throw new IllegalArgumentException("This shape is not in the animation.");
    }
    return object;
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder("Shapes:\n");
    for (Shape object:shapes) {
      str.append("Name: ").append(object.getName());
    }
    return str.toString();
  }
  @Override
  public ArrayList<Shape> getShapesAtTicker(int ticker) {
    return null;
  }

}
