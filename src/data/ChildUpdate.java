package data;

import entities.Gift;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
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
