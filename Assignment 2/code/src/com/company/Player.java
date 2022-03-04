package com.company;

public class Player {
    // Class for the players on the team


    private String playerName;
    private int numOfGoals;
    private int numOfAssist;
    private int totalPointsOfPlayer;


    //Constructor
    public Player(String playerName, int numOfGoals, int numOfAssist) {
        this.setPlayerName(playerName);
        this.setNumOfGoals(numOfGoals);
        this.setNumOfAssist(numOfAssist);
        this.setTotalPointsOfPlayer(this.getNumOfGoals() + this.getNumOfAssist());
    }


    //Getters and Setters
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getNumOfGoals() {
        return numOfGoals;
    }

    public void setNumOfGoals(int numOfGoals) {
        this.numOfGoals = numOfGoals;
    }

    public int getNumOfAssist() {
        return numOfAssist;
    }

    public void setNumOfAssist(int numOfAssist) {
        this.numOfAssist = numOfAssist;
    }

    public int getTotalPointsOfPlayer() {
        return totalPointsOfPlayer;
    }

    public void setTotalPointsOfPlayer(int totalPointsOfPlayer) {
        this.totalPointsOfPlayer = totalPointsOfPlayer;
    }
}
