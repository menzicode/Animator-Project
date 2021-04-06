package model;

import java.util.Comparator;

public class TransformationTimeComparator implements Comparator<Transformation> {
  @Override
  public int compare(Transformation t1, Transformation t2) {
    return t1.getStartTime() - t2.getStartTime();
  }
}