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
  public void addMoveTransformation(Shape shape, double newX, double newY, int timeStart,
                                    int timeEnd) {
    if (newX < 0 || newY < 0) {
      throw new IllegalArgumentException("Coordinates must be a positive!");
    }
    if (!shapes.contains(shape)) {
      throw new NoSuchElementException("Shape not in the animation, please add the shape first!");
    }
    transformationList.add(shape.move(newX, newY, timeStart, timeEnd));
  }

  @Override
  public void addRectangleSizeTransformation(Rectangle rectangle, double newWidth, double newHeight,
                                             int timeStart, int timeEnd) {
    if (newWidth < 0 || newHeight < 0) {
      throw new IllegalArgumentException("Width and height must be positive numbers!");
    }
    if (!shapes.contains(rectangle)) {
      throw new NoSuchElementException("Shape not in the animation, please add the shape first!");
    }
    transformationList.add(rectangle.changeSize(newWidth, newHeight, timeStart, timeEnd));
  }

  @Override
  public void addOvalSizeTransformation(Oval oval, double newRadiusX, double newRadiusY,
                                        int timeStart, int timeEnd) {
    if (newRadiusX < 0 || newRadiusY < 0) {
      throw new IllegalArgumentException("newRadiusX and newRadiusY must be positive numbers!");
    }
    if (!shapes.contains(oval)) {
      throw new NoSuchElementException("Shape not in the animation, please add the shape first!");
    }
    transformationList.add(oval.changeSize(newRadiusX, newRadiusY, timeStart, timeEnd));
  }

  @Override
  public void addCircleSizeTransformation(Circle circle, double newRadius, int timeStart,
                                          int timeEnd) {
    if (newRadius < 0) {
      throw new IllegalArgumentException("newRaidius must be a positive number!");
    }
    if (!shapes.contains(circle)) {
      throw new NoSuchElementException("Shape not in the animation, please add the shape first!");
    }
    transformationList.add(circle.changeSize(newRadius, timeStart, timeEnd));
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
    Collections.sort(transformationList, new TransformationTimeComparator());
    StringBuilder str = new StringBuilder("Shapes:");
    for (Shape object : shapes) {
      str.append("\n").append(object.toString()).append("\n");
    }
    str.append("\n");
    for (Transformation object : transformationList) {
      str.append(object.toString());
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
