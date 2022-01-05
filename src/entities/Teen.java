package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Teen extends Child{

    //    public Teen(){
//        super();
//    }
    public Teen(Child ch){
        this.setFirstName(ch.getFirstName());
        this.setLastName(ch.getLastName());
        this.setAge(ch.getAge());
        this.setCity(ch.getCity());
        this.setAssignedBudget(ch.getAssignedBudget());
        this.setNiceScore(ch.getNiceScore());
        this.setId(ch.getId());
        this.setGiftsPreferences(ch.getGiftsPreferences());
        this.setNiceScoreHistory(ch.getNiceScoreHistory());
        this.setReceivedGifts(ch.getReceivedGifts());
    }

    @Override
    public Double calculateAvgScore() {
        Double nr = 0.0;
        Double sum = 0.0;
        Double index = 1.0;

        for(Double score : this.getNiceScoreHistory()){
            sum += (score * index);
            nr += index;
            index++;
        }

        if (Double.compare(nr, 0.0) == 0 || Double.compare(sum, 0.0) == 0){
            return this.getNiceScore();
        }

        Double avg = sum/nr;
        this.setAverageScore(avg);
        System.out.println("AVG SCORE = " + avg);
        return avg;
    }

}
