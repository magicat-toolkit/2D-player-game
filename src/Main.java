import enums.Actions;
import enums.CellsEnum;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        player player = new player();
        Actions actions = Actions.DOWN;


        while (player.isWin) {

            player.printMap();

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
                    case UP -> player.actionW();
                    case LEFT -> player.actionA();
                    case DOWN -> player.actionS();
                    case RIGHT -> player.actionD();
                    case INVENTORY -> player.printInv();
                    default -> System.out.println("ERROR: char not valid!");
                }
            }
            catch (StringIndexOutOfBoundsException e){
                System.out.println("ERROR: insert a things in the action bar!");
            }











        }

    }
}