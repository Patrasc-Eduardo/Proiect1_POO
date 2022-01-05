package main;

import DesignPatterns.ChildFactory;
import data.ActionData;
import database.MainDB;
import entities.Child;
import entities.Gift;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class ProcessInput {
  private int firstRound = 0;

  public void eliminateAdults(ArrayList<Child> childList) {
    childList.removeIf(ch -> ch.getAge() >= 18);
  }

  public void init(ActionData input) {
    int numberOfYears = input.getNumberOfYears();
    Double initialSantaBudget = input.getSantaBudget();
    MainDB mainDB = MainDB.getInstance();

    System.out.println("numberOfYears : " + numberOfYears);
    System.out.println("santaBudget : " + initialSantaBudget);

    if (this.getFirstRound() == 0) {
      // Take Initial Child List, Santa Budget, Santa GiftList
      mainDB.setChildrenList(input.getInitialData().getChildren());
      mainDB.getSanta().setSantaBudget(initialSantaBudget);
      mainDB.getSanta().setSantaGiftList(input.getInitialData().getSantaGiftsList());

      // System.out.println("Initial database :");
      // System.out.println(mainDB);

      // System.out.println("gift list " + input.getInitialData().getSantaGiftsList());
      // Sort by age
      ChildFactory chFactory = new ChildFactory();
      ArrayList<Child> childrenList = new ArrayList<>();

      for (Child ch : mainDB.getChildrenList()) {

        ch = chFactory.createChild(ch.getAge(), ch);

        childrenList.add(ch);
      }
      ////////

      eliminateAdults(childrenList);

      mainDB.setChildrenList(childrenList);

      ArrayList<Double> allChildAvg = new ArrayList<>();

      for (Child ch : mainDB.getChildrenList()) {
        ch.calculateAvgScore();
        allChildAvg.add(ch.getAverageScore());
      }

      Double budgetUnit = mainDB.getSanta().calculateBudgetUnit(allChildAvg);

      System.out.println("Budget Unit " + budgetUnit);

      for (Child ch : mainDB.getChildrenList()) {
        ch.calculateAssignedBudget(budgetUnit);
      }

      HashMap<String, ArrayList<Gift>> santaGiftMap = mainDB.getSanta().giftListToMap();
      ArrayList<Gift> arr = new ArrayList<>();

      // while (Double.compare(initialSantaBudget, 0.0) > 0) {
      for (Child ch : mainDB.getChildrenList()) {
        Double childAssignedBudget = ch.getAssignedBudget();
        System.out.println("assigned child " + childAssignedBudget);
        System.out.println("child " + ch);

        if (Double.compare(childAssignedBudget, 0.0) > 0) {
          for (String prefs : ch.getGiftsPreferences()) {
            System.out.println("Pref " + prefs);
            if (santaGiftMap.containsKey(prefs)) {

              arr = santaGiftMap.get(prefs);

              if (!arr.isEmpty()) {

                System.out.println("before arr " + arr);
                arr.sort(((o1, o2) -> o1.getPrice().compareTo(o2.getPrice())));
                System.out.println("after arr " + arr);
                Gift minGift = arr.get(0);

                int compAssignedBudget = Double.compare(minGift.getPrice(), childAssignedBudget);
                int compInitialSantaBudget = Double.compare(minGift.getPrice(), initialSantaBudget);
                //                if (minGift.getPrice() <= childAssignedBudget
                //                    && minGift.getPrice() <= initialSantaBudget) {
                if ((compAssignedBudget < 0 || compAssignedBudget == 0) && (compInitialSantaBudget < 0
                    || compInitialSantaBudget == 0)) {

                  ch.getReceivedGifts().add(minGift);
                  //santaGiftMap.get(prefs).remove(0);
                  childAssignedBudget -= minGift.getPrice();
                  initialSantaBudget -= minGift.getPrice();

                }
                // }
              }
            }
          }
          // initialSantaBudget -= child alocated budget
          //break;
        }
      }
      firstRound = 1;
      System.out.println();
      System.out.println("######################## Round " + 0 + "#############################");
      System.out.println(mainDB.getChildrenList());
    }
    else {
      for(int i = 0; i < input.getNumberOfYears(); i++){

      }
    }

  }
}
