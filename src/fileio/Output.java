package fileio;
import java.util.ArrayList;

public class Output {
    private ArrayList<AnnualOutput> annualChildren = new ArrayList<>();

    public ArrayList<AnnualOutput> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(ArrayList<AnnualOutput> annualChildren) {
        this.annualChildren = annualChildren;
    }

    @Override
    public String toString() {
        return "Output{" +
                "outputList=" + annualChildren +
                '}';
    }
}
