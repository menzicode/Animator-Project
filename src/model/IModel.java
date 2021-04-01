package model;

import java.util.ArrayList;

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
   * Returns a string description of the animation.
   */
  String toString();

  /**
   * Used to set the transformation of the shape;
   */
  void setTransformation();

  /**
   * Returns a collection of copy of shapes at specific time.
   *
   * @param ticker instance of time
   */
  ArrayList<Shape> getShapesAtTicker(int ticker);
}
