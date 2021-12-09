package data;

import entities.Child;
import entities.Gift;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class AnnualChange {
  private Double newSantaBudget;
  private ArrayList<Gift> newGifts;
  private ArrayList<Child> newChildren;
  private ArrayList<ChildUpdate> childrenUpdates;

  public AnnualChange(
      final Double newSantaBudget,
      final ArrayList<Gift> newGifts,
      final ArrayList<Child> newChildren,
      final ArrayList<ChildUpdate> childrenUpdates) {
    this.newSantaBudget = newSantaBudget;
    this.newGifts = newGifts;
    this.newChildren = newChildren;
    this.childrenUpdates = childrenUpdates;
  }

  @Override
  public String toString() {
    return "AnnualChange{"
        + "\n"
        + "newSantaBudget="
        + newSantaBudget
        + "\n"
        + ", newGifts="
        + newGifts
        + "\n"
        + ", newChildren="
        + newChildren
        + "\n"
        + ", childrenUpdates="
        + childrenUpdates
        + "\n"
        + '}';
  }
}
