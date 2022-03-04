package com.company;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Team {
    //Class for the teams


    //Creates class properties
    private String teamName;
    private ArrayList<Player> playersOnTeam;
    private int totalTeamGoals;
    private int totalTeamAssist;
    private int totalTeamPoints;
    private double teamBudget;
    private String teamRating;


    //Constructor
    public Team(String teamName) {
        //Constructor for the class
        setTeamName(teamName);
        this.teamBudget = ThreadLocalRandom.current().nextDouble(0, 100000); //Generates random number between 0 and 100000
    }

    //Getters and Setters
    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public ArrayList<Player> getPlayersOnTeam() {
        return playersOnTeam;
    }

    public void setPlayersOnTeam(ArrayList<Player> playersOnTeam) {

        this.playersOnTeam = playersOnTeam;

        //Updating the teams total points
        for (Player i : this.playersOnTeam) {
            //loops through each player in the array and gets the goals, and assists
            this.totalTeamGoals += i.getNumOfGoals();
            this.totalTeamAssist += i.getNumOfAssist();
            this.totalTeamPoints += i.getTotalPointsOfPlayer();
        }
    }

    public String getTeamRating() {
        //Calculating teams rating
        if (this.totalTeamPoints >= 30) this.teamRating = "CLASS A";
        else if (this.totalTeamPoints >= 20) this.teamRating = "CLASS B";
        else if (this.totalTeamPoints > 0) this.teamRating = "CLASS C";
        else this.teamRating = "CLASS D";

        return this.teamRating;


    }

    //More getters and setters

    public int getTotalTeamGoals() {
        return this.totalTeamGoals;
    }
    public int getTotalTeamAssist() {
        return this.totalTeamAssist;
    }

    public int getTotalTeamPoints() {
        return this.totalTeamPoints;
    }
    public double getTeamBudget() {
        return this.teamBudget;
    }
}
