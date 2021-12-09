package data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
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
