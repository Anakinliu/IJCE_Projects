package com.ThingInJava;

import static com.Print.print;

/**
 * Created by liu_y.
 * On 2016/10/23.
 */
class Game {
    Game(int i) {
        print("Game constructor" + i);
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        // print("BoardGame constructor"); // call to super must be first
        // statement in constructor
        super(i); // else: "cannot find symbol: constructor Game()
        print("BoardGame constructor" + i);
    }
}

public class Chess extends BoardGame {
    Chess() {
        super(11);
        print("last : Chess constructor");
    }
    BoardGame bg = new BoardGame(666);//在构造器前被调用
    public static void main(String[] args) {
        System.out.println("MAIN");
        Chess x = new Chess();
    }
}