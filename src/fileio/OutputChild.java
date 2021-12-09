package fileio;

import enums.Cities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class OutputChild {
    private int id;
    private String lastName;
    private String firstName;
    private Cities city;
    private int age;
    private ArrayList<String> giftsPreferences;
    private Double averageScore;
    private ArrayList<Double> niceScoreHistory;
    private Double assignedBudget;
    private ArrayList<Double> receivedGifts;
}
