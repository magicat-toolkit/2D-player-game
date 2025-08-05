package main;

import enums.Actions;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        logicMenager logicMenager = new logicMenager();
        Actions actions = Actions.DOWN;


        while (logicMenager.isWin) {

            logicMenager.printMap();

            System.out.print("Enter an action(W,A,S,D,I): ");
            char cmd = scanner.nextLine().toUpperCase().charAt(0);




            try {

                switch (cmd){
                    case 'W' -> actions = Actions.UP;
                    case 'A' -> actions = Actions.LEFT;
                    case 'S' -> actions = Actions.DOWN;
                    case 'D' -> actions = Actions.RIGHT;
                    case 'I' -> actions = Actions.INVENTORY;
                    default -> System.out.println("ERROR: char not valid!");
                }

                switch (actions){
                    case UP -> logicMenager.moveUp();
                    case LEFT -> logicMenager.moveLeft();
                    case DOWN -> logicMenager.moveDown();
                    case RIGHT -> logicMenager.moveRight();
                    case INVENTORY -> logicMenager.printInv();
                    default -> System.out.println("ERROR: char not valid!");
                }
            }
            catch (StringIndexOutOfBoundsException e){
                System.out.println("ERROR: insert a things in the action bar!");
            }

        }

    }
}