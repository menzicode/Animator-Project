package model;

import java.util.ArrayList;
import java.util.Comparator;

public interface IModel {

  /**
   * Adds a given shape to the animation. The shape is in the animation for a set amount of time.
   */
  void addShape(Shape object);

  /**
   * Removes a given shape. Throws an IllegalArgumentException if the shape is not in the
   * animation.
   *
   * @param object a model.Shape object in the animation
   * @throws IllegalArgumentException if the shape does not exist in the animation
   */
  void removeShape(Shape object);

  /**
   * Returns specific shape from the animation. An IllegalArgumentException is thrown if the shape
   * is not in the animation.
   *
   * @param object the model.Shape to be returned from the animation
   * @throws IllegalArgumentException if the shape does not exist in the animation
   */
  Shape getSpecificShape(Shape object);

  /**
   * Sorts the list of shapes by time.
   * @param comp the time comparison, earliest to latest
   */
  void sort(ShapeTimeComparator comp);

  /**
   * Returns a string description of the animation.
   */
  String toString();

  /**
   * Returns a collection of copy of shapes at specific time.
   *
   * @param ticker instance of time
   */
  ArrayList<Shape> getShapesAtTicker(int ticker);
}
