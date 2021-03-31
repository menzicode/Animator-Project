/**
 * Class used to store the start and end time values for Shape class.
 */
public class Ticker {
  public int appears;
  public int disappears;

  /**
   * Constructs a Ticker object that has an appear and disappear time. If either time is less than
   * zero or they equal each other than an IllegalArgumentException is thrown.
   * @param appears time as an integer of when the shape appears
   * @param disappears time as an integer of when shape disappears.
   * @throws IllegalArgumentException when either time is less than zero or are equal to each other
   */
  public Ticker(int appears, int disappears) {
    if (appears < 0 || disappears < 0 || appears == disappears) {
      throw new IllegalArgumentException("Parameters may not be less than zero or equal.");
    }
    this.appears = appears;
    this.disappears = disappears;
  }

  public int getAppears() {
    return appears;
  }

  public int getDisappears() {
    return disappears;
  }
}
