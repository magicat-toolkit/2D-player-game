import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        player player = new player();


        while (player.isWin) {

            player.printMap();

            System.out.print("Enter an action(W,A,S,D,I): ");
            char cmd = scanner.nextLine().toUpperCase().charAt(0);




            try {;
                switch (cmd){
                    case 'W' -> player.actionW();
                    case 'A' -> player.actionA();
                    case 'S' -> player.actionS();
                    case 'D' -> player.actionD();
                    case 'I' -> player.printInv();
                    default -> System.out.println("ERROR: char not valid!");
                }
            }
            catch (StringIndexOutOfBoundsException e){
                System.out.println("ERROR: insert a things in the action bar!");
            }











        }

    }
}