package model;

import java.util.Comparator;

/**
 * This class is a comparator for two shape objects, sorting them in ascending time appearance.
 */
public class ShapeTimeComparator implements Comparator<Shape> {
  @Override
  public int compare(Shape shape1, Shape shape2) {
    return shape1.getAppearance() - shape2.getAppearance();
  }
}
