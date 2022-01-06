package data;
import java.util.ArrayList;

public class ChildUpdate {
  private int id;
  private Double niceScore;
  private ArrayList<String> giftsPreferences;

  public ChildUpdate(
      final int id, final Double niceScore, final ArrayList<String> giftsPreferences) {
    this.id = id;
    this.niceScore = niceScore;
    this.giftsPreferences = giftsPreferences;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Double getNiceScore() {
    return niceScore;
  }

  public void setNiceScore(Double niceScore) {
    this.niceScore = niceScore;
  }

  public ArrayList<String> getGiftsPreferences() {
    return giftsPreferences;
  }

  public void setGiftsPreferences(ArrayList<String> giftsPreferences) {
    this.giftsPreferences = giftsPreferences;
  }

  @Override
  public String toString() {
    return "ChildUpdate{"
        + "\n"
        + "id="
        + id
        + "\n"
        + ", niceScore="
        + niceScore
        + "\n"
        + ", giftsPreferences="
        + giftsPreferences
        + "\n"
        + '}';
  }
}
