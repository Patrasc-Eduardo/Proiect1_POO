package fileio;

import data.AnnualChange;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
@NoArgsConstructor
public class Output {
    private ArrayList<AnnualOutput> annualChildren = new ArrayList<>();

    @Override
    public String toString() {
        return "Output{" +
                "outputList=" + annualChildren +
                '}';
    }
}
