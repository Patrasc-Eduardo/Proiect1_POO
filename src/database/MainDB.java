package database;

import entities.Child;
import entities.Santa;
import java.util.ArrayList;

public final class MainDB {
  private static MainDB instance = null;
  private final Santa santa = new Santa();
  private ArrayList<Child> childrenList = new ArrayList<>();

  private MainDB() { }

  /** @return instanta bazei de date de tip Singleton. */
  public static MainDB getInstance() {
    if (instance == null) {
      instance = new MainDB();
    }
    return instance;
  }

  public Santa getSanta() {
    return santa;
  }

  public ArrayList<Child> getChildrenList() {
    return childrenList;
  }

  public void setChildrenList(final ArrayList<Child> childrenList) {
    this.childrenList = childrenList;
  }

  @Override
  public String toString() {
    return "MainDB{" + "santa=" + santa + ", childrenList=" + childrenList + '}';
  }
}
