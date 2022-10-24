package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Line 8-10 basic print out statements
        System.out.println("***********");
        System.out.println("  Let's play wordle ");
        System.out.println("        ************");
        //Get a random word  which is the answer
        String correctWord = Util.getRandomWord();//derives random word from the resources  folder
        //System.out.println(correctWord); // for testing purposes

        char[] word = new char[5];// create a char array that holds 5 elements ( 5 letters)
        for (int i = 0; i < 5; i++)
            word[i] = correctWord.charAt(i);
        char[] input = new char[5];//use this for the user's entered word
        boolean Finished = false;// set it to a default of false,however turns to true  when correct word is guessed and the loop end
        boolean Game = true; //game finished or not
        int chancesCount = 1;//initialized for the attempts we have
        int chancesLimit = 6;//limit of attempts

        String userGuess = " ";// empty string
        // while loop is the loop for the game ;

        while (Game != Finished) {
            Scanner guess = new Scanner(System.in);//Allows for user input
            userGuess = " ";
            // if else statement that controls the number of times one can guess the mystery word.
            if (chancesCount < chancesLimit || chancesCount == chancesLimit) {
                System.out.println("\nEnter your guess :" + chancesCount + " of 6 attempts");// prints ou what attempts one is one
                userGuess = guess.nextLine().toLowerCase();// Reads user input  allows both lower and uppercase entry
                //the statement that checks length of a string
                if (userGuess.length() == 5) {
                    chancesCount++;// counter
                    for (int userIndex = 0; userIndex < userGuess.length(); userIndex++) {
                        char userLetter = userGuess.charAt(userIndex);
                        char computerLetter = correctWord.charAt(userIndex);
                        if (correctWord.contains(userLetter + "")) {
                            if (userLetter == computerLetter) {
                                System.out.print(Util.getFormattedLetter(userLetter, Util.Result.HIT));
                            } else {
                                System.out.print(Util.getFormattedLetter(userLetter, Util.Result.SEMI_HIT));
                            }
                        } else {
                            System.out.print(Util.getFormattedLetter(userLetter, Util.Result.MISS));
                        }
                    }
                if (userGuess.equals(correctWord)) {
                        System.out.println("\n***There you go Champ***");
                        Game = Finished;
                    }

                    }
                // if user doesn't  a five letter word
                else {
                    System.out.println("\nMust enter a five letter word");
                }

                }
            // if user runs out of attempts and no correct guess then this message pops up
            else {  System.out.println("\nGAME OVER:YOU ARE OUT OF ATTEMPTS");//If you do not guess  word and finish your attempts
                System.out.println("Word of the day is: " + correctWord);
                break;
            }


        }

    }
}















