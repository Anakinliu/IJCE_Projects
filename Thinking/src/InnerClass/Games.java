package InnerClass;

/**
 * Created by Anakinliu on 2017/2/9.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame();
}

class Checkers implements Game {

    private int moves = 0;

    private static final int MOVES = 3;

    //防止直接创建对象
    private Checkers() {}

    @Override
    public boolean move() {
        System.out.println("Checkers move " + MOVES);
        return ++moves != MOVES;
    }

    //lambda expression
    public static GameFactory factory = Checkers::new;
}

class Chess implements Game {

    private Chess() {}

    private int moves = 0;

    private static final int MOVES = 4;


    //lambda expression
    public static GameFactory factory = Chess::new;

    @Override
    public boolean move() {
        System.out.println("Chess move " + moves);
        return ++moves != MOVES;
    }
}


public class Games {

    public static void playGame(GameFactory factory) {
        Game s = factory.getGame();
        while (s.move())
            ;
    }








}
