package entities;

import DesignPatterns.AverageScoreStrategy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;


public class Child implements AverageScoreStrategy {
  private int id;
  private String lastName;
  private String firstName;
  private String city;
  private int age;
  private ArrayList<String> giftsPreferences;
  private Double averageScore;//
  private ArrayList<Double> niceScoreHistory = new ArrayList<>();//
  @JsonIgnore
  private Double niceScore;
  private Double assignedBudget;//
  private ArrayList<Gift> receivedGifts = new ArrayList<>();//

  public Child(
      final int id,
      final String lastName,
      final String firstName,
      final int age,
      final String city,
      final Double niceScore,
      final ArrayList<String> giftsPreferences
      ) {
    this.id = id;
    this.age = age;
    this.city = city;
    this.lastName = lastName;
    this.firstName = firstName;
    this.giftsPreferences = giftsPreferences;
    this.niceScore = niceScore;
    this.niceScoreHistory.add(niceScore);
  }

  public Child(
          final int id,
          final String lastName,
          final String firstName,
          final int age,
          final String city,
          final Double niceScore,
          final ArrayList<String> giftsPreferences,
          final Double averageScore,
          final ArrayList<Double> niceScoreHistory,
          final Double assignedBudget,
          final ArrayList<Gift> receivedGifts) {
    this.id = id;
    this.age = age;
    this.city = city;
    this.lastName = lastName;
    this.firstName = firstName;
    this.giftsPreferences = giftsPreferences;
    this.niceScore = niceScore;
    this.niceScoreHistory.add(niceScore);
    this.averageScore = averageScore;
    this.niceScoreHistory = niceScoreHistory;
    this.assignedBudget = assignedBudget;
    this.receivedGifts = receivedGifts;
  }

  public Child(Child child){
        this.id = child.id;
        this.age = child.age;
        this.lastName = child.lastName;
        this.city = child.city;
        this.firstName = child.firstName;
        this.niceScore = child.niceScore;
        //this.giftsPreferences = child.giftsPreferences;
        this.giftsPreferences = new ArrayList<>(child.getGiftsPreferences());
        //this.niceScoreHistory = child.niceScoreHistory;
        this.niceScoreHistory = new ArrayList<>(child.getNiceScoreHistory());
        this.averageScore = child.averageScore;
        this.assignedBudget = child.assignedBudget;
        //this.receivedGifts = child.receivedGifts;
        this.receivedGifts = new ArrayList<>(child.getReceivedGifts());
  }

    public Child() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(ArrayList<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(Double niceScore) {
        this.niceScore = niceScore;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(ArrayList<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public void calculateAssignedBudget(Double budgetUnit){
    if (averageScore != null && budgetUnit != null){
     assignedBudget = averageScore * budgetUnit;
        //assignedBudget = BigDecimal.valueOf(averageScore).multiply(BigDecimal.valueOf(budgetUnit));
    }
    //return this.assignedBudget;
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
            ", city='" + city + '\'' +
            ", age=" + age +
            ", niceScore=" + niceScore +
            ", giftsPreferences=" + giftsPreferences +
            ", averageScore=" + averageScore +
            ", niceScoreHistory=" + niceScoreHistory +
            ", assignedBudget=" + assignedBudget +
            ", receivedGifts=" + receivedGifts +
            '}';
  }

  @Override
  public void calculateAvgScore() {
    //return averageScore;
  }
}
