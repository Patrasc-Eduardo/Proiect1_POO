package main;

import DesignPatterns.ChildFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.ActionData;
import data.AnnualChange;
import data.ChildUpdate;
import database.MainDB;
import entities.Child;
import entities.Gift;
import entities.Santa;
import fileio.AnnualOutput;
import fileio.Output;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
public class ProcessInput {
  private int firstRound = 0;

  public void eliminateAdults(ArrayList<Child> childList) {
    childList.removeIf(ch -> ch.getAge() > 18);
  }

  public void removeReceivedGifts(ArrayList<Child> childList) {
    for (Child ch : childList) {
      ch.getReceivedGifts().clear();
    }
  }

  public void addNewChildren(ArrayList<Child> childList, ArrayList<Child> newChildList) {
    for (Child ch : newChildList) {
      if (ch.getAge() <= 18) {
        childList.add(ch);
      }
    }
  }

//  public void removeScores(ArrayList<Child> childList){
//    for (Child ch : childList) {
//      ch.getNiceScoreHistory().clear();
//    }
//  }

  public void updateOldChilds(ArrayList<Child> childList, AnnualChange anChange) {

    for (Child ch : childList) {
      ch.setAge(ch.getAge() + 1);
    }

    childList.removeIf(ch -> ch.getAge() > 18);
    System.out.println("Annual children update " + anChange);
    for (ChildUpdate chUpd : anChange.getChildrenUpdates()) {
      System.out.println("CHUPD IDDD " + chUpd.getId());
      Child child = findById(childList, chUpd.getId());
      //System.out.println("Found child " + child.getFirstName());
      if (child != null) {

        if (chUpd.getNiceScore() != null) {
          child.getNiceScoreHistory().add(chUpd.getNiceScore());
        }
        System.out.println("Ch upd gift pref " + chUpd.getGiftsPreferences());
        if (!chUpd.getGiftsPreferences().isEmpty()) {
          System.out.println("chupd gift pref + " + chUpd.getGiftsPreferences());
          Collections.reverse(chUpd.getGiftsPreferences());
          for (String pref : chUpd.getGiftsPreferences()) {
            System.out.println("Updated pref + " + pref);
            if (child.getGiftsPreferences().toString().contains(pref)) {
              System.out.println("FOUND DUPLICATE " + pref);
              child.getGiftsPreferences().remove(pref);
              child.getGiftsPreferences().add(0, pref);
              //Collections.reverse(child.getGiftsPreferences());
            }
            else  {
              child.getGiftsPreferences().add(0, pref);
            }

          }
        }
      }
    }
  }

  public Child findById(ArrayList<Child> childList, int id) {
    for (Child ch : childList) {
      if (ch.getId() == id) {
        return ch;
      }
    }
    return null;
  }

  public void updateOldSanta(Santa santa, AnnualChange anChange) {
    santa.setSantaBudget(anChange.getNewSantaBudget());

    for (Gift gift : anChange.getNewGifts()) {
      if (checkForDuplicateGifts(gift.getProductName(), santa.getSantaGiftList()) == 0) {
        santa.getSantaGiftList().add(gift);
      }
    }
  }

  public int checkForDuplicateGifts(String newGift, ArrayList<Gift> giftList) {
    for (Gift gift : giftList) {
      if (gift.getProductName().compareTo(newGift) == 0) {
        return 1;
      }
    }
    return 0;
  }

  public void init(ActionData input, String filePath2) throws IOException {
    int numberOfYears = input.getNumberOfYears();
    Double initialSantaBudget = input.getSantaBudget();
    MainDB mainDB = MainDB.getInstance();
    Output output = new Output();
    ObjectMapper objectMapper = new ObjectMapper();

    //objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath2), output);
    //File outputFile = new File(filePath2);

    //System.out.println("numberOfYears : " + numberOfYears);
    //System.out.println("santaBudget : " + initialSantaBudget);

    if (this.getFirstRound() == 0) {
      // Take Initial Child List, Santa Budget, Santa GiftList
      AnnualOutput anOutput = new AnnualOutput();

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
        System.out.println("child " + ch.getFirstName());
        System.out.println("assigned child " + childAssignedBudget);

        if (Double.compare(childAssignedBudget, 0.0) > 0) {
          for (String prefs : ch.getGiftsPreferences()) {
            //System.out.println("Pref " + prefs);
            if (santaGiftMap.containsKey(prefs)) {

              arr = santaGiftMap.get(prefs);

              if (!arr.isEmpty()) {

                //System.out.println("before arr " + arr);
                arr.sort(((o1, o2) -> o1.getPrice().compareTo(o2.getPrice())));
                //System.out.println("after arr " + arr);
                Gift minGift = arr.get(0);

                int compAssignedBudget = Double.compare(minGift.getPrice(), childAssignedBudget);
                int compInitialSantaBudget = Double.compare(minGift.getPrice(), initialSantaBudget);

                if ((compAssignedBudget < 0 || compAssignedBudget == 0)
                    && (compInitialSantaBudget < 0 || compInitialSantaBudget == 0)) {
                  System.out.println("added GIFT " + minGift.getProductName());
                  ch.getReceivedGifts().add(minGift);
                  // santaGiftMap.get(prefs).remove(0);
                  childAssignedBudget -= minGift.getPrice();
                  initialSantaBudget -= minGift.getPrice();
                }
                // }
              }
            }
          }
          // initialSantaBudget -= child alocated budget
          // break;
        }
      }
      firstRound = 1;
      System.out.println();
      System.out.println("######################## Round " + 0 + "#############################");
      //System.out.println(mainDB.getChildrenList());

      /////anOutput.getChildren().addAll(mainDB.getChildrenList());
      ////output.getAnnualChildren().add(anOutput);

      ArrayList<Child> firstRoundChildren = new ArrayList<>();

      for(Child ch : mainDB.getChildrenList()){
        firstRoundChildren.add(new Child(ch));
      }

      anOutput.getChildren().addAll(firstRoundChildren);
      output.getAnnualChildren().add(anOutput);
    }
    // else {
    for (int i = 0; i < input.getNumberOfYears(); i++) {
      AnnualOutput annualOutput = new AnnualOutput();

      System.out.println(
          "############### Round "
              + (i + 1)
              + "######################"
              + "##################################################");

      AnnualChange anChange = input.getAnnualChanges().get(i);

      removeReceivedGifts(mainDB.getChildrenList());
      //removeScores(mainDB.getChildrenList());
      //System.out.println("After removal" + output.getAnnualChildren().get(0));
      updateOldChilds(mainDB.getChildrenList(), anChange);

      addNewChildren(mainDB.getChildrenList(), anChange.getNewChildren());

      updateOldSanta(mainDB.getSanta(), anChange);

      initialSantaBudget = mainDB.getSanta().getSantaBudget();
      System.out.println("Santa Budget " + initialSantaBudget);

      ChildFactory chFactory = new ChildFactory();
      ArrayList<Child> childrenList = new ArrayList<>();

      for (Child ch : mainDB.getChildrenList()) {

        ch = chFactory.createChild(ch.getAge(), ch);
        System.out.println("Created " + ch.getLastName() + " " + ch.getFirstName() + " with age "
        + ch.getAge());
        childrenList.add(ch);
      }

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

      for (Child ch : mainDB.getChildrenList()) {
        Double childAssignedBudget = ch.getAssignedBudget();

        System.out.println();
        System.out.println("child " + ch.getFirstName() + " " + ch.getLastName());
        System.out.println("assigned child " + childAssignedBudget);
        System.out.println();

        if (Double.compare(childAssignedBudget, 0.0) > 0) {
          for (String prefs : ch.getGiftsPreferences()) {
            //System.out.println("Pref " + prefs);
            if (santaGiftMap.containsKey(prefs)) {

              arr = santaGiftMap.get(prefs);

              if (!arr.isEmpty()) {

                //System.out.println("before arr " + arr);
                arr.sort(((o1, o2) -> o1.getPrice().compareTo(o2.getPrice())));

                System.out.println();
                System.out.println("after arr " + arr);
                System.out.println();

                Gift minGift = arr.get(0);

                int compAssignedBudget = Double.compare(minGift.getPrice(), childAssignedBudget);
                int compInitialSantaBudget = Double.compare(minGift.getPrice(), initialSantaBudget);

                System.out.println();

                System.out.println("compAssigned " + compAssignedBudget);
                System.out.println("compInitial " + compInitialSantaBudget);
                System.out.println("initial Santa Budget " + initialSantaBudget);
                System.out.println();

                if ((compAssignedBudget < 0 || compAssignedBudget == 0)
                    && (compInitialSantaBudget < 0 || compInitialSantaBudget == 0)) {
                  System.out.println("RECEIVED GIFT " + minGift.getProductName());
                  ch.getReceivedGifts().add(minGift);
                  // santaGiftMap.get(prefs).remove(0);
                  childAssignedBudget -= minGift.getPrice();
                  initialSantaBudget -= minGift.getPrice();
                }
                // }
              }
            }
          }
        }
      }

      System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
      //System.out.println("Output" + mainDB.getChildrenList());
//      annualOutput.getChildren().addAll(mainDB.getChildrenList());
//      output.getAnnualChildren().add(anOutput);

//      ObjectMapper objectMapper = new ObjectMapper();
//      objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath2), output);

      ArrayList<Child> childList = new ArrayList<>();

      for(Child ch : mainDB.getChildrenList()){
        childList.add(new Child(ch));
      }

      annualOutput.getChildren().addAll(childList);
      output.getAnnualChildren().add(annualOutput);
      //System.out.println(output);

    }
    objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath2), output);
  }
}
