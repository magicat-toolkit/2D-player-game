package main;

import enums.CellsEnum;

public class logicMenager {



    int pos_x = 5;
    int pos_y = 5;
    boolean isWin = true;
    char[][] map = {{'K','.','.','.','.','.','.','.','L','.','.'},
                    {'.','O','.','.','.','.','.','.','.','.','.'},
                    {'.','.','.','.','.','.','.','.','.','.','.'},
                    {'.','.','.','.','.','.','.','.','.','.','.'},
                    {'.','.','.','.','.','.','.','.','.','.','.'},
                    {'.','.','.','.','.','P','.','.','.','.','.'},
                    {'.','.','.','.','.','.','.','.','.','.','.'},
                    {'.','.','.','.','.','.','.','.','.','.','.'},
                    {'.','.','.','.','.','.','.','.','.','.','.'},
                    {'.','.','.','.','.','.','.','.','.','o','.'},
                    {'.','.','.','.','.','.','.','.','.','.','.'}};

    char[][] map1 = {{'.','.','.','.','.','.','.','.','W','.','.'},
                     {'.','.','.','.','.','.','.','.','.','.','.'},
                     {'.','.','.','.','.','.','.','.','.','.','.'},
                     {'.','.','.','.','.','.','.','.','.','.','.'},
                     {'.','.','.','.','.','.','.','.','.','.','.'},
                     {'.','.','.','.','.','P','.','.','.','.','.'},
                     {'.','.','.','.','.','.','.','.','.','.','.'},
                     {'.','.','.','.','.','.','.','.','.','.','.'},
                     {'.','.','.','.','.','.','.','.','.','.','.'},
                     {'.','.','.','.','.','.','.','.','.','.','.'},
                     {'.','.','.','.','.','.','.','.','.','.','.'}};

    char[] inventory = new char[2];

    CellsEnum cellsEnum;



    int numberSquare = 10;
    int startX = 5;
    int startY = 5;

    void moveUp() {
        if (pos_x == 0) {
            pos_x = 0;
        }
        else {
            map[pos_x][pos_y] = '.';
            pos_x--;

            switch (map[pos_x][pos_y]){

                case 'W' -> cellsEnum = CellsEnum.DOOR;
                case '.' -> cellsEnum = CellsEnum.AIR;
                case 'K' -> cellsEnum = CellsEnum.KEY;
                case 'L' -> cellsEnum = CellsEnum.LOCKEDDOOR;
                case '█' -> cellsEnum = CellsEnum.WALL;
                case 'O' -> cellsEnum = CellsEnum.PORTAL1;
                case 'o' -> cellsEnum = CellsEnum.PORTAL2;
            }

            switch (cellsEnum){
                case DOOR -> {
                    pos_x = startY;
                    pos_y = startX;

                    if (map == map1){
                        isWin = false;
                        System.out.println("you win!");
                    }
                    map = map1;
                }
                case AIR -> map[pos_x][pos_y] = 'P';
                case KEY -> {
                    map[pos_x][pos_y] = 'P';
                    inventory[0] = 'K';
                }
                case LOCKEDDOOR ->{
                    if (inventory[0] == 'K'){
                        pos_x = startY;
                        pos_y = startX;

                        if (map == map1){
                            System.out.println("you win!");
                            isWin = false;
                        }
                        map = map1;
                        inventory[0] = ' ';
                    }
                    else {
                        System.out.println("the win is locked!");
                        pos_x++;
                        map[pos_x][pos_y] = 'P';

                    }
                }
                case WALL -> {
                    pos_x++;
                    map[pos_x][pos_y] = 'P';

                }
                case PORTAL1 -> {
                    for (int a = 0; a < map.length; a++) {
                        for (int o = 0; o < map.length; o++) {
                            if (map[o][a] == 'o') {
                                pos_x = o;
                                pos_y = a;
                                pos_x--;
                                map[pos_x][pos_y] = 'P';


                            }
                        }
                    }
                }
                case PORTAL2 -> {
                    for (int a = 0; a < map.length; a++) {
                        for (int o = 0; o < map.length; o++) {
                            if (map[o][a] == 'O') {
                                pos_x = o;
                                pos_y = a;
                                pos_x--;
                                map[pos_x][pos_y] = 'P';


                            }
                        }
                    }
                }
                default -> System.out.println("ERROR 128: case " + map[pos_x][pos_y] + " doesn't exist!");
            }

        }
    }

    void moveDown() {
        if (pos_x == numberSquare) {
            pos_x = numberSquare;
        }
        else {
            map[pos_x][pos_y] = '.';
            pos_x++;

            switch (map[pos_x][pos_y]){

                case 'W' -> cellsEnum = CellsEnum.DOOR;
                case '.' -> cellsEnum = CellsEnum.AIR;
                case 'K' -> cellsEnum = CellsEnum.KEY;
                case 'L' -> cellsEnum = CellsEnum.LOCKEDDOOR;
                case '█' -> cellsEnum = CellsEnum.WALL;
                case 'O' -> cellsEnum = CellsEnum.PORTAL1;
                case 'o' -> cellsEnum = CellsEnum.PORTAL2;
            }

            switch (cellsEnum){
                case DOOR -> {
                    pos_x = startY;
                    pos_y = startX;

                    if (map == map1){
                        isWin = false;
                        System.out.println("you win!");
                    }
                    map = map1;
                }
                case AIR -> map[pos_x][pos_y] = 'P';
                case KEY -> {
                    map[pos_x][pos_y] = 'P';
                    inventory[0] = 'K';
                }
                case LOCKEDDOOR -> {
                    if (inventory[0] == 'K'){
                        pos_x = startY;
                        pos_y = startX;

                        if (map == map1){
                            System.out.println("you win!");
                            isWin = false;
                        }
                        map = map1;
                        inventory[0] = ' ';
                    }
                    else {
                        System.out.println("the win is locked!");
                        pos_x--;
                        map[pos_x][pos_y] = 'P';

                    }
                }
                case WALL -> {
                    pos_x--;
                    map[pos_x][pos_y] = 'P';

                }
                case PORTAL1 -> {
                    for (int a = 0; a < map.length; a++) {
                        for (int o = 0; o < map.length; o++) {
                            if (map[o][a] == 'o') {
                                pos_x = o;
                                pos_y = a;
                                pos_x++;
                                map[pos_x][pos_y] = 'P';


                            }
                        }
                    }
                }
                case PORTAL2 -> {
                    for (int a = 0; a < map.length; a++) {
                        for (int o = 0; o < map.length; o++) {
                            if (map[o][a] == 'O') {
                                pos_x = o;
                                pos_y = a;
                                pos_x++;
                                map[pos_x][pos_y] = 'P';


                            }
                        }
                    }
                }
                default -> System.out.println("ERROR 128: case " + map[pos_x][pos_y] + " doesn't exist!");
            }

        }

    }

    void moveLeft(){
        if (pos_y == 0) {
            pos_y = 0;
        }
        else {

            map[pos_x][pos_y] = '.';
            pos_y--;

            switch (map[pos_x][pos_y]){

                case 'W' -> cellsEnum = CellsEnum.DOOR;
                case '.' -> cellsEnum = CellsEnum.AIR;
                case 'K' -> cellsEnum = CellsEnum.KEY;
                case 'L' -> cellsEnum = CellsEnum.LOCKEDDOOR;
                case '█' -> cellsEnum = CellsEnum.WALL;
                case 'O' -> cellsEnum = CellsEnum.PORTAL1;
                case 'o' -> cellsEnum = CellsEnum.PORTAL2;
            }

            switch (cellsEnum){
                case DOOR -> {
                    pos_x = startY;
                    pos_y = startX;

                    if (map == map1){
                        System.out.println("you win!");
                        isWin = false;
                    }
                    map = map1;
                }
                case AIR -> map[pos_x][pos_y] = 'P';
                case KEY -> {
                    map[pos_x][pos_y] = 'P';
                    inventory[0] = 'K';
                }
                case LOCKEDDOOR ->{
                    if (inventory[0] == 'K'){
                        pos_x = startY;
                        pos_y = startX;

                        if (map == map1){
                            System.out.println("you win!");
                            isWin = false;
                        }
                        map = map1;
                        inventory[0] = ' ';
                    }
                    else {
                        System.out.println("the win is locked!");
                        pos_y++;
                        map[pos_x][pos_y] = 'P';

                    }
                }
                case WALL -> {
                    pos_y++;
                    map[pos_x][pos_y] = 'P';

                }
                case PORTAL1 -> {
                    for (int a = 0; a < map.length; a++) {
                        for (int o = 0; o < map.length; o++) {
                            if (map[o][a] == 'o') {
                                pos_x = o;
                                pos_y = a;
                                pos_y--;
                                map[pos_x][pos_y] = 'P';


                            }
                        }
                    }
                }
                case PORTAL2 -> {
                    for (int a = 0; a < map.length; a++) {
                        for (int o = 0; o < map.length; o++) {
                            if (map[o][a] == 'O') {
                                pos_x = o;
                                pos_y = a;
                                pos_y--;
                                map[pos_x][pos_y] = 'P';


                            }
                        }
                    }
                }
                default -> System.out.println("ERROR 128: case " + map[pos_x][pos_y] + " doesn't exist!");
            }

        }

    }

    void moveRight(){
        if (pos_y == numberSquare) {
            pos_y = numberSquare;
        }
        else {
            map[pos_x][pos_y] = '.';
            pos_y++;

            switch (map[pos_x][pos_y]){

                case 'W' -> cellsEnum = CellsEnum.DOOR;
                case '.' -> cellsEnum = CellsEnum.AIR;
                case 'K' -> cellsEnum = CellsEnum.KEY;
                case 'L' -> cellsEnum = CellsEnum.LOCKEDDOOR;
                case '█' -> cellsEnum = CellsEnum.WALL;
                case 'O' -> cellsEnum = CellsEnum.PORTAL1;
                case 'o' -> cellsEnum = CellsEnum.PORTAL2;
            }

            switch (cellsEnum){
                case DOOR -> {
                    pos_x = startY;
                    pos_y = startX;

                    if (map == map1){
                        isWin = false;
                        System.out.println("you win!");
                    }
                    map = map1;
                }
                case AIR -> map[pos_x][pos_y] = 'P';
                case KEY -> {
                    map[pos_x][pos_y] = 'P';
                    inventory[0] = 'K';
                }
                case LOCKEDDOOR -> {
                    if (inventory[0] == 'K'){
                        pos_x = startY;
                        pos_y = startX;

                        if (map == map1){
                            System.out.println("you win!");
                            isWin = false;
                        }
                        map = map1;
                        inventory[0] = ' ';
                    }
                    else {
                        System.out.println("the win is locked!");
                        pos_y--;
                        map[pos_x][pos_y] = 'P';

                    }
                }
                case WALL -> {
                    pos_y--;
                    map[pos_x][pos_y] = 'P';

                }
                case PORTAL1 -> {
                    for (int a = 0; a < map.length; a++) {
                        for (int o = 0; o < map.length; o++) {
                            if (map[o][a] == 'o') {
                                pos_x = o;
                                pos_y = a;
                                pos_y++;
                                map[pos_x][pos_y] = 'P';


                            }
                        }
                    }
                }
                case PORTAL2 -> {
                    for (int a = 0; a < map.length; a++) {
                        for (int o = 0; o < map.length; o++) {
                            if (map[o][a] == 'O') {
                                pos_x = o;
                                pos_y = a;
                                pos_y++;
                                map[pos_x][pos_y] = 'P';


                            }
                        }
                    }
                }
                default -> System.out.println("ERROR 128: case " + map[pos_x][pos_y] + " doesn't exist!");
            }

        }

    }

    void printMap(){
        for (char[] row : map) {
            for (char col : row) {
                System.out.printf("%c ", col);
            }
            System.out.println();
        }
    }
    void printInv(){

        for (int i = 0; i < inventory.length; i++){
            if (i == 1){
                System.out.println(inventory[i]);
            }
            else {
                System.out.print(inventory[i] + ", ");
            }
        }

    }
}