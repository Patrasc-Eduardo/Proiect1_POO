package entities;

public class Kid extends Child{

    public Kid(Child ch){
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

//    public Kid(){
//        super();
//    }
    
    @Override
    public void calculateAvgScore() {
        Double nr = 0.0;
        Double sum = 0.0;

        for(Double score : this.getNiceScoreHistory()){
            sum += score;
            nr++;
        }

        if (Double.compare(nr, 0.0) == 0 || Double.compare(sum, 0.0) == 0){
            //return this.getNiceScore();
            this.setAverageScore(getNiceScore());
        }
        Double avg = sum/nr;
        this.setAverageScore(avg);
        //System.out.println("AVG SCORE = " + avg);
        //return avg;
    }
}
