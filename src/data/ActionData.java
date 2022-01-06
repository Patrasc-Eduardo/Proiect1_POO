package data;
import java.util.ArrayList;


public class ActionData {
  private int numberOfYears;
  private Double santaBudget;
  private InitialData initialData;
  private ArrayList<AnnualChange> annualChanges;

  public ActionData(
      final int numberOfYears,
      final Double santaBudget,
      final InitialData initialData,
      final ArrayList<AnnualChange> annualChanges) {
    this.numberOfYears = numberOfYears;
    this.santaBudget = santaBudget;
    this.initialData = initialData;
    this.annualChanges = annualChanges;
  }

  public int getNumberOfYears() {
    return numberOfYears;
  }

  public void setNumberOfYears(int numberOfYears) {
    this.numberOfYears = numberOfYears;
  }

  public Double getSantaBudget() {
    return santaBudget;
  }

  public void setSantaBudget(Double santaBudget) {
    this.santaBudget = santaBudget;
  }

  public InitialData getInitialData() {
    return initialData;
  }

  public void setInitialData(InitialData initialData) {
    this.initialData = initialData;
  }

  public ArrayList<AnnualChange> getAnnualChanges() {
    return annualChanges;
  }

  public void setAnnualChanges(ArrayList<AnnualChange> annualChanges) {
    this.annualChanges = annualChanges;
  }

  @Override
  public String toString() {
    return "ActionData{"
        + "\n"
        + "numberOfYears="
        + numberOfYears
        + "\n"
        + ", santaBudget="
        + santaBudget
        + "\n"
        + ", initialData="
        + initialData
        + "\n"
        + ", annualChanges="
        + annualChanges
        + "\n"
        + '}';
  }
}
