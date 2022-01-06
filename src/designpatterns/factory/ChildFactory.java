package designpatterns.factory;

import entities.Baby;
import entities.Child;
import entities.Kid;
import entities.Teen;
import entities.YoungAdult;

public final class ChildFactory {

  public static final int BABY_LOWER_LIMIT = 0;
  public static final int BABY_UPPER_LIMIT = 4;
  public static final int KID_LOWER_LIMIT = 5;
  public static final int KID_UPPER_LIMIT = 11;
  public static final int TEEN_LOWER_LIMIT = 12;
  public static final int TEEN_UPPER_LIMIT = 18;
  public static final int ADULT_LOWER_LIMIT = 19;
  public static final int ADULT_UPPER_LIMIT = 120;

  public ChildFactory() {

  }

  /**
   * @param x
   * @param lower
   * @param upper
   * @return
   */
  public boolean isBetween(final int x, final int lower, final int upper) {
    return lower <= x && x <= upper;
  }

  /**
   * @param age
   * @param ch
   * @return
   */
  public Child createChild(final int age, final Child ch) {

    if (isBetween(age, BABY_LOWER_LIMIT, BABY_UPPER_LIMIT)) {
      return new Baby(ch);
    }
    if (isBetween(age, KID_LOWER_LIMIT, KID_UPPER_LIMIT)) {
      return new Kid(ch);
    }
    if (isBetween(age, TEEN_LOWER_LIMIT, TEEN_UPPER_LIMIT)) {
      return new Teen(ch);
    }
    if (isBetween(age, ADULT_LOWER_LIMIT, ADULT_UPPER_LIMIT)) {
      return new YoungAdult(ch);
      //return null;
    }

    throw new IllegalArgumentException("The child age " + age + " is not recognized.");
  }
}
