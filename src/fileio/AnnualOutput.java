package fileio;

import entities.Child;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class AnnualOutput {
    private ArrayList<Child> annualChilds = new ArrayList<>();
}
