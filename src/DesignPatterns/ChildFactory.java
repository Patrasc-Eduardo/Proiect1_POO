package DesignPatterns;

import entities.Baby;
import entities.Child;
import entities.Kid;
import entities.Teen;
import entities.YoungAdult;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChildFactory {

  public boolean isBetween(int x, int lower, int upper) {
    return lower <= x && x <= upper;
  }

  public Child createChild(int age, Child ch) {
    boolean bool;

    if (isBetween(age, 0, 4)) {
      return new Baby(ch);
    }
    if (isBetween(age, 5, 12)) {
      return new Kid(ch);
    }
    if (isBetween(age, 12, 18)) {
      return new Teen(ch);
    }
    if (isBetween(age, 18, 120)) {
      return new YoungAdult(ch);
      //return null;
    }

    throw new IllegalArgumentException("The child age " + age + " is not recognized.");
  }
}
