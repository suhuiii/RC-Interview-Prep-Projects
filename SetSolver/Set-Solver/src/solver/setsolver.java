package solver;

public class setsolver {

    public Card generateACard(){
        return new Card(Card.Colors.getRandom(), Card.Symbols.getRandom(), Card.Numbers.getRandom());
    }

    boolean matchInColor(Card one, Card two, Card three){
        if(one.color == two.color && two.color == three.color)
            return true;
        if(one.color != two.color && two.color != three.color && three.color != one.color)
            return true;
        return false;
    }

    boolean matchInSymbol(Card one, Card two, Card three){
        if(one.symbol == two.symbol && two.symbol == three.symbol)
            return true;
        if(one.symbol != two.symbol && two.symbol != three.symbol && three.symbol != one.symbol)
            return true;
        return false;
    }

    boolean matchInNumber(Card one, Card two, Card three){
        if(one.number == two.number && two.number == three.number)
            return true;
        if(one.number != two.number && two.number != three.number && three.number != one.number)
            return true;
        return false;
    }
    
    public boolean checkMatches(Card... cards) {
        if(cards.length == 3) {
            if (matchInColor(cards[0], cards[1], cards[2]))
                if (matchInSymbol(cards[0], cards[1], cards[2]))
                    if (matchInNumber(cards[0], cards[1], cards[2]))
                        return true;
            return false;
        }else
            return false;
    }

}
