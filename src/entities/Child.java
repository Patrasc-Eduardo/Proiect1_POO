package entities;

import DesignPatterns.AverageScoreStrategy;
import enums.Cities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Child implements AverageScoreStrategy {
  private int id;
  private String lastName;
  private String firstName;
  private int age;
  private String city;
  private Double niceScore;
  private ArrayList<String> giftsPreferences;
  private Double averageScore;//
  private ArrayList<Double> niceScoreHistory = new ArrayList<>();//
  private Double assignedBudget;//
  private ArrayList<Gift> receivedGifts = new ArrayList<>();//

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
    this.niceScoreHistory.add(niceScore);
  }

  public Double calculateAssignedBudget(Double budgetUnit){
    if (averageScore != null && budgetUnit != null){
     assignedBudget = averageScore * budgetUnit;
        //assignedBudget = BigDecimal.valueOf(averageScore).multiply(BigDecimal.valueOf(budgetUnit));

    }
    return this.assignedBudget;
  }

//  @Override
//  public String toString() {
//    return "Child{"
//        + "\n"
//        + "id="
//        + id
//        + "\n"
//        + ", lastName='"
//        + lastName
//        + '\''
//        + "\n"
//        + ", firstName='"
//        + firstName
//        + '\''
//        + "\n"
//        + ", age="
//        + age
//        + "\n"
//        + ", city='"
//        + city
//        + '\''
//        + "\n"
//        + ", niceScore="
//        + niceScore
//        + "\n"
//        + ", giftsPreferences="
//        + giftsPreferences
//        + "\n"
//        + '}';
//  }


  @Override
  public String toString() {
    return "Child{" +
            "id=" + id +
            ", lastName='" + lastName + '\'' +
            ", firstName='" + firstName + '\'' +
            ", age=" + age +
            ", city='" + city + '\'' +
            ", niceScore=" + niceScore +
            ", giftsPreferences=" + giftsPreferences +
            ", averageScore=" + averageScore +
            ", niceScoreHistory=" + niceScoreHistory +
            ", assignedBudget=" + assignedBudget +
            ", receivedGifts=" + receivedGifts +
            '}';
  }

  @Override
  public Double calculateAvgScore() {
    return averageScore;
  }
}
