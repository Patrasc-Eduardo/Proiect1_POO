package data;

import entities.Child;
import entities.Gift;
import enums.Cities;
import java.util.ArrayList;


public class InitialData {
  private ArrayList<Child> children = new ArrayList<>();
  private ArrayList<Gift> santaGiftsList = new ArrayList<>();
  private ArrayList<Cities> initCitiesList = new ArrayList<>();

  public InitialData(){

  }

  public InitialData(
      final ArrayList<Child> children,
      final ArrayList<Gift> santaGiftsList,
      final ArrayList<Cities> initCitiesList) {
    this.children = children;
    this.santaGiftsList = santaGiftsList;
    this.initCitiesList = initCitiesList;
  }

  public ArrayList<Child> getChildren() {
    return children;
  }

  public void setChildren(ArrayList<Child> children) {
    this.children = children;
  }

  public ArrayList<Gift> getSantaGiftsList() {
    return santaGiftsList;
  }

  public void setSantaGiftsList(ArrayList<Gift> santaGiftsList) {
    this.santaGiftsList = santaGiftsList;
  }

//  public ArrayList<Cities> getInitCitiesList() {
//    return initCitiesList;
//  }
//
//  public void setInitCitiesList(ArrayList<Cities> initCitiesList) {
//    this.initCitiesList = initCitiesList;
//  }

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
