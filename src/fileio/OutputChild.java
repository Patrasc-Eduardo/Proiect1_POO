package fileio;

import enums.Cities;
import java.util.ArrayList;

public final class OutputChild {
  private int id;
  private String lastName;
  private String firstName;
  private Cities city;
  private int age;
  private ArrayList<String> giftsPreferences = new ArrayList<>();
  private Double averageScore;
  private ArrayList<Double> niceScoreHistory = new ArrayList<>();
  private Double assignedBudget;
  private ArrayList<Double> receivedGifts = new ArrayList<>();

  public int getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public Cities getCity() {
    return city;
  }

  public void setCity(final Cities city) {
    this.city = city;
  }

  public int getAge() {
    return age;
  }

  public void setAge(final int age) {
    this.age = age;
  }

  public ArrayList<String> getGiftsPreferences() {
    return giftsPreferences;
  }

  public void setGiftsPreferences(final ArrayList<String> giftsPreferences) {
    this.giftsPreferences = giftsPreferences;
  }

  public Double getAverageScore() {
    return averageScore;
  }

  public void setAverageScore(final Double averageScore) {
    this.averageScore = averageScore;
  }

  public ArrayList<Double> getNiceScoreHistory() {
    return niceScoreHistory;
  }

  public void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
    this.niceScoreHistory = niceScoreHistory;
  }

  public Double getAssignedBudget() {
    return assignedBudget;
  }

  public void setAssignedBudget(final Double assignedBudget) {
    this.assignedBudget = assignedBudget;
  }

  public ArrayList<Double> getReceivedGifts() {
    return receivedGifts;
  }

  public void setReceivedGifts(final ArrayList<Double> receivedGifts) {
    this.receivedGifts = receivedGifts;
  }
}
