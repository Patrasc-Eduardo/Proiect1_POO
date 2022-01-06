package utilsprocess;

import designpatterns.factory.ChildFactory;
import data.AnnualChange;
import data.ChildUpdate;
import database.MainDB;
import entities.Child;
import entities.Gift;
import entities.Santa;
import fileio.AnnualOutput;
import fileio.Output;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public final class UtilsProcess {

  public static final int ADULT_AGE = 18;
  private UtilsProcess() { }

  /** @param childList */
  public static void eliminateAdults(final ArrayList<Child> childList) {
    childList.removeIf(ch -> ch.getAge() > ADULT_AGE);
  }

  /** @param childList */
  public static void removeReceivedGifts(final ArrayList<Child> childList) {
    for (Child ch : childList) {
      ch.getReceivedGifts().clear();
    }
  }

  /**
   * @param childList
   * @param newChildList
   */
  public static void addNewChildren(
      final ArrayList<Child> childList, final ArrayList<Child> newChildList) {
    for (Child ch : newChildList) {
      if (ch.getAge() <= ADULT_AGE) {
        childList.add(ch);
      }
    }
  }

  /**
   * @param childList
   * @param id
   * @return
   */
  public static Child findById(final ArrayList<Child> childList, final int id) {
    for (Child ch : childList) {
      if (ch.getId() == id) {
        return ch;
      }
    }
    return null;
  }

  /**
   * @param childList
   * @param anChange
   */
  public static void updateOldChilds(
      final ArrayList<Child> childList, final AnnualChange anChange) {

    for (Child ch : childList) {
      ch.setAge(ch.getAge() + 1);
    }

    childList.removeIf(ch -> ch.getAge() > ADULT_AGE);

    for (ChildUpdate chUpd : anChange.getChildrenUpdates()) {

      Child child = findById(childList, chUpd.getId());

      if (child != null) {

        if (chUpd.getNiceScore() != null) {
          child.getNiceScoreHistory().add(chUpd.getNiceScore());
        }

        if (!chUpd.getGiftsPreferences().isEmpty()) {

          Collections.reverse(chUpd.getGiftsPreferences());
          for (String pref : chUpd.getGiftsPreferences()) {

            if (child.getGiftsPreferences().toString().contains(pref)) {

              child.getGiftsPreferences().remove(pref);
              child.getGiftsPreferences().add(0, pref);

            } else {
              child.getGiftsPreferences().add(0, pref);
            }
          }
        }
      }
    }
  }

  /**
   * @param newGift
   * @param giftList
   * @return
   */
  public static int checkForDuplicateGifts(final String newGift, final ArrayList<Gift> giftList) {
    for (Gift gift : giftList) {
      if (gift.getProductName().compareTo(newGift) == 0) {
        return 1;
      }
    }
    return 0;
  }

  /**
   * @param santa
   * @param anChange
   */
  public static void updateOldSanta(final Santa santa, final AnnualChange anChange) {
    santa.setSantaBudget(anChange.getNewSantaBudget());

    for (Gift gift : anChange.getNewGifts()) {
      if (checkForDuplicateGifts(gift.getProductName(), santa.getSantaGiftList()) == 0) {
        santa.getSantaGiftList().add(gift);
      }
    }
  }

  /**
   * @param childrenList
   * @param databaseChild
   */
  public static void createChildrenByAge(
      final ArrayList<Child> childrenList, final ArrayList<Child> databaseChild) {
    ChildFactory chFactory = new ChildFactory();

    for (Child ch : databaseChild) {

      ch = chFactory.createChild(ch.getAge(), ch);

      childrenList.add(ch);
    }
  }

  /**
   * @param avgScoreList
   * @param childList
   */
  public static void calculateAllAvgScores(
      final ArrayList<Double> avgScoreList, final ArrayList<Child> childList) {
    for (Child ch : childList) {
      ch.calculateAvgScore();
      avgScoreList.add(ch.getAverageScore());
    }
  }

  /**
   * @param childList
   * @param budgetUnit
   */
  public static void calculateAllChildAssignedBudget(
      final ArrayList<Child> childList, final Double budgetUnit) {
    for (Child ch : childList) {
      ch.calculateAssignedBudget(budgetUnit);
    }
  }

  /**
   * @param mainDB
   * @param output
   */
  public static void sendToOutput(final MainDB mainDB, final Output output) {
    AnnualOutput anOutput = new AnnualOutput();
    ArrayList<Child> firstRoundChildren = new ArrayList<>();

    for (Child ch : mainDB.getChildrenList()) {
      firstRoundChildren.add(new Child(ch));
    }

    anOutput.getChildren().addAll(firstRoundChildren);
    output.getAnnualChildren().add(anOutput);
  }

  /**
   * @param mainDB
   * @param initialSantaBudget
   */
  public static void sendGifts(final MainDB mainDB, Double initialSantaBudget) {
    HashMap<String, ArrayList<Gift>> santaGiftMap = mainDB.getSanta().giftListToMap();
    ArrayList<Gift> arr;

    for (Child ch : mainDB.getChildrenList()) {
      Double childAssignedBudget = ch.getAssignedBudget();

      if (Double.compare(childAssignedBudget, 0.0) > 0) {
        for (String prefs : ch.getGiftsPreferences()) {

          if (santaGiftMap.containsKey(prefs)) {

            arr = santaGiftMap.get(prefs);

            if (!arr.isEmpty()) {

              arr.sort((Comparator.comparing(Gift::getPrice)));

              Gift minGift = arr.get(0);

              int compAssignedBudget = Double.compare(minGift.getPrice(), childAssignedBudget);
              int compInitialSantaBudget = Double.compare(minGift.getPrice(), initialSantaBudget);

              if ((compAssignedBudget < 0 || compAssignedBudget == 0)
                  && (compInitialSantaBudget < 0 || compInitialSantaBudget == 0)) {

                ch.getReceivedGifts().add(minGift);
                childAssignedBudget -= minGift.getPrice();
                initialSantaBudget -= minGift.getPrice();
              }
            }
          }
        }
      }
    }
  }
}
