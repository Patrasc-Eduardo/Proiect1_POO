package data;

import entities.Child;
import entities.Gift;
import enums.Cities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class InitialData {
  private ArrayList<Child> children = new ArrayList<>();
  private ArrayList<Gift> santaGiftsList = new ArrayList<>();
  private ArrayList<Cities> initCitiesList = new ArrayList<>();

  public InitialData(
      final ArrayList<Child> children,
      final ArrayList<Gift> santaGiftsList,
      final ArrayList<Cities> initCitiesList) {
    this.children = children;
    this.santaGiftsList = santaGiftsList;
    this.initCitiesList = initCitiesList;
  }

  @Override
  public String toString() {
    return "InitialData{"
        + "\n"
        + "children="
        + children
        + "\n"
        + ", santaGiftsList="
        + santaGiftsList
        + "\n"
        + ", initCitiesList="
        + initCitiesList
        + "\n"
        + '}';
  }
}
