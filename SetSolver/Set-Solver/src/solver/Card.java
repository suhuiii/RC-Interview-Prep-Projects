package solver;

import java.util.Random;

public class Card {
    public enum Colors{
        RED,
        GREEN,
        PURPLE;
        public static Colors getRandom(){
            return values()[new Random().nextInt(values().length )];
        }
    };
    public enum Symbols{
        OVAL,
        SQUIGGLE,
        DIAMOND;
        public static Symbols getRandom(){
            return values()[new Random().nextInt(values().length )];
        }
    };
    public enum Numbers{
        ONE,
        TWO,
        THREE;
        public static Numbers getRandom(){
            return values()[new Random().nextInt(values().length )];
        }
    }
    final Colors color;
    final Symbols symbol;
    final Numbers number;
    public Card(Colors col, Symbols sym, Numbers num){
        color = col;
        symbol = sym;
        number = num;
    }
}
