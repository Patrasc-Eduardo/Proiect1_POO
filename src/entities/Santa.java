package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
public class Santa {
    private Double santaBudget;
    private ArrayList<Gift> santaGiftList;
    private Double budgetUnit;

    public Santa(Double santaBudget, ArrayList<Gift> santaGiftList){
        this.santaBudget = santaBudget;
        this.santaGiftList = santaGiftList;
        this.budgetUnit = 0.0;
    }

//    public Double calculateBudgetUnit(Double[] allChildAvg){
//
//        if (Double.compare(santaBudget, 0.0) != 0){
//            Double sum = Arrays.stream(allChildAvg).mapToDouble(Double::doubleValue).sum();
//            budgetUnit = santaBudget / sum;
//            return budgetUnit;
//        }
//
//        return 0.0;
//    }

    public Double calculateBudgetUnit(ArrayList<Double> allChildAvg){

        if (Double.compare(santaBudget, 0.0) != 0 && allChildAvg != null){
            //Double[] allChildAvgArr = (Double[]) allChildAvg.toArray();
            //Double sum = Arrays.stream(allChildAvgArr).mapToDouble(Double::doubleValue).sum();
            Double sum = 0.0;

            for(Double db : allChildAvg){
                if (db != null) {
                    sum += db;
                }

            }
            System.out.println("ALL CHILD AVG = " + sum);
            budgetUnit = santaBudget / sum;
            return budgetUnit;
        }

        return 0.0;

    }

    public HashMap<String, ArrayList<Gift>> giftListToMap(){
        HashMap<String, ArrayList<Gift>> giftMap = new HashMap<>();
        //System.out.println("santa gift list + " + santaGiftList);
        for(Gift gift : santaGiftList){
            //System.out.println("santa gift list + " + santaGiftList);
            if (!giftMap.containsKey(gift.getCategory())){ // daca nu contine
                ArrayList<Gift> gifts = new ArrayList<>();
                gifts.add(gift);
                giftMap.put(gift.getCategory(), gifts);
            }
            else {
                giftMap.get(gift.getCategory()).add(gift);
            }
        }

        return giftMap;
    }

    @Override
    public String toString() {
        return "Santa{" +
                "santaBudget=" + santaBudget +
                ", santaGiftList=" + santaGiftList +
                '}';
    }
}
