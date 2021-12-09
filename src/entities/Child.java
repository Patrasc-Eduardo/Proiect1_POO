package entities;

import enums.Cities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Child {
  private int id;
  private String lastName;
  private String firstName;
  private int age;
  private String city;
  private Double niceScore;
  private ArrayList<String> giftsPreferences;

  public Child(
      final int id,
      final String lastName,
      final String firstName,
      final int age,
      final String city,
      final Double niceScore,
      final ArrayList<String> giftsPreferences) {
    this.id = id;
    this.age = age;
    this.city = city;
    this.lastName = lastName;
    this.firstName = firstName;
    this.giftsPreferences = giftsPreferences;
    this.niceScore = niceScore;
  }

  @Override
  public String toString() {
    return "Child{"
        + "\n"
        + "id="
        + id
        + "\n"
        + ", lastName='"
        + lastName
        + '\''
        + "\n"
        + ", firstName='"
        + firstName
        + '\''
        + "\n"
        + ", age="
        + age
        + "\n"
        + ", city='"
        + city
        + '\''
        + "\n"
        + ", niceScore="
        + niceScore
        + "\n"
        + ", giftsPreferences="
        + giftsPreferences
        + "\n"
        + '}';
  }
}
