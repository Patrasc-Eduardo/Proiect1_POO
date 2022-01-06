package entities;

import DesignPatterns.AverageScoreStrategy;

public class Baby extends Child implements AverageScoreStrategy {


    public Baby(Child ch){

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

//    public Baby(){
//     super();
//    }

//    public Baby() {
//
//    }

    @Override
    public void calculateAvgScore() {
        this.setAverageScore(10.0);
        //System.out.println("AVG SCORE = " + 10.0);
        //return 10.0;
    }
}
