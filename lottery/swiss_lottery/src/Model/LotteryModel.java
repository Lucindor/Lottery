package Model;

import View.Tip;


import java.util.ArrayList;
import java.util.Random;

public class LotteryModel {

    private int counterNumbers =0;
    private int tipCounter =0;
    private int counterLuckyNumbers = 0;
    private static final int MAX_NUMBERS = 6;
    private static final int MAX_LUCKYNUMBERS = 1;
    private static final int MAX_TIPS = 10;

    public ArrayList<Integer> getChosenNumbers() {
        return chosenNumbers;
    }

    public ArrayList<Integer> getChosenLuckyNumber() {
        return chosenLuckyNumber;
    }

    private ArrayList<Integer> chosenNumbers = new ArrayList<>();
    private ArrayList<Integer> chosenLuckyNumber = new ArrayList<>();
    private ArrayList<Tip> tips = new ArrayList<>();

    private Random generator = new Random();


    public LotteryModel(){

    }

    public boolean isPossible() {

        /** checks if the user can choose another one or not */
        return getCounterNumbers() < MAX_NUMBERS;
    }

    public boolean isPossibleLucky(){

        /** checks if the user can choose another one or not */
        return getCounterLuckyNumbers() < MAX_LUCKYNUMBERS;
    }

    public boolean isComplete(){
        return (!isPossible()) && (!isPossibleLucky());
    }

    public ArrayList<Integer> generateRandomNumbers() {

        int generatedNumber;
        boolean finished = false;

        /** making sure the arraylist is empty */
        chosenNumbers.clear();

        /** generates random numbers and checks whether there are duplicates or not */
        while (!finished) {
            generatedNumber = generator.nextInt((42)) + 1;

            if (chosenNumbers.isEmpty() || !isDuplicate(generatedNumber)) {
                chosenNumbers.add(generatedNumber);
                if (chosenNumbers.size() == MAX_NUMBERS) {
                    finished = true;
                }
            }
        }
        return chosenNumbers;
    }

    public ArrayList<Integer> generateRandomLuckyNumber() {
        chosenLuckyNumber.clear();
        chosenLuckyNumber.add(generator.nextInt(6)+1);
        return chosenLuckyNumber;
    }

    private boolean isDuplicate(int n){
        boolean isTwice = false;
        for (int i = 0; i < chosenNumbers.size(); i++){
            if(chosenNumbers.get(i)== n){
                isTwice = true;
                break;
            }
        }
        return isTwice;
    }

    public boolean isTipPossible(){
        return tipCounter < MAX_TIPS;

    }

    public void deleteNr() {
        counterNumbers--;
    }

    public void addNr(){
        counterNumbers++;
    }

    private int getCounterNumbers(){return counterNumbers;}

    private int getCounterLuckyNumbers() {
        return counterLuckyNumbers;
    }

    public void addLuckyNr() {
        counterLuckyNumbers++;
    }

    public void deleteLuckyNr(){
        counterLuckyNumbers--;
    }
    public void setCounterNumbers(int counterNumbers) {
        this.counterNumbers = counterNumbers;
    }

    public void setCounterLuckyNumbers(int counterLuckyNumbers) {
        this.counterLuckyNumbers = counterLuckyNumbers;
    }
    public void addTip(){
        tipCounter++;
    }

    public ArrayList<Tip> getTips() {
        return tips;
    }

    public void removeTip() {
        tipCounter--;
    }
    public int getTipCounter() {
        return tipCounter;
    }
}

