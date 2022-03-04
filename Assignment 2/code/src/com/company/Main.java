package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static boolean isGoodName(String s) {
        //Gets string s and checks if the length is longer than 3 characters

        return s.length() >= 3; //Returns True if the length is 3 or more, false if not

    }


    static int getNumber(String s) {
        //Takes in variable s as string which is the prompt for the user, and ensures that we are 1: given a number, and 2: that number is 0 or more
        Scanner sc = new Scanner(System.in);
        int returnNum = 0;
        boolean runAgain = true;

        do {
            try {
                System.out.print(s);
                returnNum = sc.nextInt();

                if (returnNum >= 0) runAgain = false;
                else System.out.println("That number was a negative number, try again");
                sc.nextLine();


            }
            catch (Exception e) {
                System.out.println("That was not a number try again");
                sc.nextLine();
            }

        } while (runAgain);
        return returnNum;


    }


    public static void getLines(int runs) {
        //Simple function to print out the lines for formatting
        for (int i = 0; i < runs; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public static void main(String[] args) {
	    //Assignment two
        /*
            Author: Jack MacKinnon
            Date: Feb 15, 2022
         */

        //Declaring variables
            Scanner sc = new Scanner(System.in);
            ArrayList<Team> teamList = new ArrayList<>();



        System.out.println("FANTASY HOCKEY APPLICATION\n\nTEAM ENTRY\n");
        getLines(30);
        System.out.println();

        //For loop to get the Teams and the team names, then add to the team array

        for (int i = 0; i < 3; i++) {
            boolean checkingName = false;
            String tempTeamName = "";
            do {
                System.out.printf("Enter name for team #%d:\n", (i + 1));
                tempTeamName = sc.nextLine();
                checkingName = isGoodName(tempTeamName);
                if (!checkingName) System.out.println("The name you entered is less than 3 characters, try again");
            } while (!checkingName);
            teamList.add(new Team(tempTeamName));
        }

        //For loop to gather data for the players on the team
        System.out.println("\nPLAYER ENTRY");
        getLines(30);
        System.out.println();


        for (Team i: teamList) {
            //Loop that iterates through all the teams that are defined in the team array and takes input that will make new players for each of the teams

            System.out.printf("Enter players for %s:\n", i.getTeamName());
            System.out.println();
            //Declaring new player list

                ArrayList<Player> playersOnTeam = new ArrayList<>();


            for (int counter = 0; counter < 4; counter++) {
                //Declaring variables
                    String tempPlayerName = "";
                    int numOfGoals;
                    int numOfAssists;
                    boolean checkingName = false;

                do {
                    System.out.printf("Enter name for player #%d:\n", (counter + 1));
                    tempPlayerName = sc.nextLine();
                    checkingName = isGoodName(tempPlayerName);
                    if (!checkingName) System.out.println("The name you entered is less than 3 characters, try again");
                } while (!checkingName);

                numOfGoals = getNumber(String.format("Enter number of goals for %s: \n", tempPlayerName));

                numOfAssists = getNumber(String.format("Enter number of assists for %s: \n", tempPlayerName));

                playersOnTeam.add(new Player(tempPlayerName, numOfGoals, numOfAssists));


            }


            i.setPlayersOnTeam(playersOnTeam);




        }


        //Making the report

            System.out.println("REPORT: Stats per Team\n");
            getLines(30);
            for (Team team : teamList) {
                System.out.printf("%s: G- %d\tA- %d\tTotal- %d\tBudget- $%.2f\nRating: %s\n", team.getTeamName(), team.getTotalTeamGoals(), team.getTotalTeamAssist(), team.getTotalTeamPoints(), team.getTeamBudget(), team.getTeamRating());
            }
            System.out.println("\n");


        //Making the per player report

            System.out.println("REPORT: Stats per Player\n");
            getLines(30);


            //For loop for the players on the team
            for (Team myTeam : teamList) {
                //Inner for loop to get the player names
                for (Player myPlayer : myTeam.getPlayersOnTeam()) {
                    // Getting the players in the team
                    System.out.printf("%s\n\n", myTeam.getTeamName());
                    System.out.printf("%s:\tG-%d\tA-%d\tTotal-%d\n\n", myPlayer.getPlayerName(), myPlayer.getNumOfGoals(), myPlayer.getNumOfAssist(), myPlayer.getTotalPointsOfPlayer());
                }
            }


    }
}
