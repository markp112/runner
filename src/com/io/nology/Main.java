package com.io.nology;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidEnergyLevel {
	// write your code here

        boolean isDead = false;
        char action;
        String result="";
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter starting energy level for runner 0 - 10");
        int energy = keyboard.nextInt();

        Runner currentRunner = new Runner(energy);
        System.out.println("enter one of the following commands (r)un, (s)leep, (w)ee, (e)at or (q)uit");
        String command = keyboard.next();
        int milesRan = 0;
        System.out.println(command);
        action = command.charAt(0);

        while (action != 'q' && !isDead) {

            if (command.toLowerCase().equals("run") || command.toLowerCase().equals("r")) {
                System.out.println("Enter miles run");
                milesRan = keyboard.nextInt();
            }

            switch (action) {
                case 'r':
                    result = currentRunner.run(milesRan);
                    break;
                case 'e':
                    result = currentRunner.eat();
                    break;
                case 's':
                    result = currentRunner.sleep();
                    break;
                case 'w':
                    result = currentRunner.wee();
                    break;
                case 'q':
                default:
                    System.out.println("Command not recognised");

            }
            System.out.println(result);
            if (result.equals("The runner has died")) {
                isDead = true;
            } else {
                System.out.println("Enter Commmand:");
                command = keyboard.next();
                action = command.charAt(0);
            }
        }
    }
}
