package data;

import entities.Child;
import entities.Gift;
import java.util.ArrayList;

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

  public Double getNewSantaBudget() {
    return newSantaBudget;
  }

  public void setNewSantaBudget(Double newSantaBudget) {
    this.newSantaBudget = newSantaBudget;
  }

  public ArrayList<Gift> getNewGifts() {
    return newGifts;
  }

  public void setNewGifts(ArrayList<Gift> newGifts) {
    this.newGifts = newGifts;
  }

  public ArrayList<Child> getNewChildren() {
    return newChildren;
  }

  public void setNewChildren(ArrayList<Child> newChildren) {
    this.newChildren = newChildren;
  }

  public ArrayList<ChildUpdate> getChildrenUpdates() {
    return childrenUpdates;
  }

  public void setChildrenUpdates(ArrayList<ChildUpdate> childrenUpdates) {
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
