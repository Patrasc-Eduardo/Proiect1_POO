package entities;

import designpatterns.strategy.AverageScoreStrategy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;

public class Child implements AverageScoreStrategy {
  private int id;
  private String lastName;
  private String firstName;
  private String city;
  private int age;
  private ArrayList<String> giftsPreferences;
  private Double averageScore;
  private ArrayList<Double> niceScoreHistory = new ArrayList<>();
  @JsonIgnore private Double niceScore;
  private Double assignedBudget;
  private ArrayList<Gift> receivedGifts = new ArrayList<>();

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

  public Child(final Child child) {
    this.id = child.id;
    this.age = child.age;
    this.lastName = child.lastName;
    this.city = child.city;
    this.firstName = child.firstName;
    this.niceScore = child.niceScore;
    this.giftsPreferences = new ArrayList<>(child.getGiftsPreferences());
    this.niceScoreHistory = new ArrayList<>(child.getNiceScoreHistory());
    this.averageScore = child.averageScore;
    this.assignedBudget = child.assignedBudget;
    this.receivedGifts = new ArrayList<>(child.getReceivedGifts());
  }

  public Child() { }

  public final int getId() {
    return id;
  }

  public final void setId(final int id) {
    this.id = id;
  }

  public final String getLastName() {
    return lastName;
  }

  public final void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public final String getFirstName() {
    return firstName;
  }

  public final void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public final String getCity() {
    return city;
  }

  public final void setCity(final String city) {
    this.city = city;
  }

  public final int getAge() {
    return age;
  }

  public final void setAge(final int age) {
    this.age = age;
  }

  public final ArrayList<String> getGiftsPreferences() {
    return giftsPreferences;
  }

  public final void setGiftsPreferences(final ArrayList<String> giftsPreferences) {
    this.giftsPreferences = giftsPreferences;
  }

  public final Double getAverageScore() {
    return averageScore;
  }

  public final void setAverageScore(final Double averageScore) {
    this.averageScore = averageScore;
  }

  public final ArrayList<Double> getNiceScoreHistory() {
    return niceScoreHistory;
  }

  public final void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
    this.niceScoreHistory = niceScoreHistory;
  }

  public final Double getNiceScore() {
    return niceScore;
  }

  public final void setNiceScore(final Double niceScore) {
    this.niceScore = niceScore;
  }

  public final Double getAssignedBudget() {
    return assignedBudget;
  }

  public final void setAssignedBudget(final Double assignedBudget) {
    this.assignedBudget = assignedBudget;
  }

  public final ArrayList<Gift> getReceivedGifts() {
    return receivedGifts;
  }

  public final void setReceivedGifts(final ArrayList<Gift> receivedGifts) {
    this.receivedGifts = receivedGifts;
  }

  /**
   * Calculeaza bugetul asignat.
   * @param budgetUnit
   */
  public void calculateAssignedBudget(final Double budgetUnit) {
    if (averageScore != null && budgetUnit != null) {
      assignedBudget = averageScore * budgetUnit;
    }
  }

  @Override
  public final String toString() {
    return "Child{"
        + "id="
        + id
        + ", lastName='"
        + lastName
        + '\''
        + ", firstName='"
        + firstName
        + '\''
        + ", city='"
        + city
        + '\''
        + ", age="
        + age
        + ", niceScore="
        + niceScore
        + ", giftsPreferences="
        + giftsPreferences
        + ", averageScore="
        + averageScore
        + ", niceScoreHistory="
        + niceScoreHistory
        + ", assignedBudget="
        + assignedBudget
        + ", receivedGifts="
        + receivedGifts
        + '}';
  }

  @Override
  public void calculateAvgScore() {

  }
}
