package cs5004.animator.model;

import java.util.Comparator;

/**
 * This class compares transformations in ascending time appearance order.
 */
public class TransformationTimeComparator implements Comparator<Transformation> {
  @Override
  public int compare(Transformation t1, Transformation t2) {
    return t1.getStartTime() - t2.getStartTime();
  }
}