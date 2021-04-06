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
  protected ArrayList<Transformation> transformationList;
  protected int shapeCount;

  /**
   * Constructs an animation model that starts with an empty animation screen.
   */
  public IModelImpl() {
    this.shapes = new ArrayList<>();
    this.transformationList = new ArrayList<>();
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
  public void addColorTransformation(Shape shape, int red, int green, int blue, int timeStart,
                                     int timeEnd) {
    if (red < 0 || green < 0 || blue < 0) {
      throw new IllegalArgumentException("Colors must be positive value!");
    }
    if (!shapes.contains(shape)) {
      throw new NoSuchElementException("Shape not in the animation, please add the shape first!");
    }

    transformationList.add(shape.changeColor(red, green, blue, timeStart, timeEnd));
  }

  @Override
  public void addMoveTransformation(Shape shape, double newX, double newY, int timeStart, int timeEnd) {

  }

  @Override
  public void addSizeTransformation(Rectangle rectangle, double newWidth, double newHeight, int timeStart, int timeEnd) {

  }

  @Override
  public void addSizeTransformation(Oval oval, double newRadiusX, double newRadiusY, int timeStart, int timeEnd) {

  }

  @Override
  public void addSizeTransformation(Circle circle, double newRadius, int timeStart, int timeEnd) {

  }

  @Override
  public void sort(ShapeTimeComparator comp) {
    Collections.sort(shapes, new ShapeTimeComparator());
  }

  @Override
  public void sortTransformations(TransformationTimeComparator comp) {
    Collections.sort(transformationList, new TransformationTimeComparator());
  }

  @Override
  public String toString() {
    Collections.sort(shapes, new ShapeTimeComparator());
    StringBuilder str = new StringBuilder("Shapes:\n");
    for (Shape object : shapes) {
      str.append(object.toString()).append("\n");
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
