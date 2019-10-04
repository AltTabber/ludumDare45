import com.alttabber.games.cards.BaseAttackCard;
import com.alttabber.games.cards.BaseDefenceCard;
import com.alttabber.games.gameobjects.Card;
import com.alttabber.games.gameobjects.Deck;

public class Main {

    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.addToDeck(new BaseAttackCard());
        deck.addToDeck(new BaseAttackCard());
        deck.addToDeck(new BaseAttackCard());
        deck.addToDeck(new BaseAttackCard());
        deck.addToDeck(new BaseAttackCard());
        deck.addToDeck(new BaseAttackCard());
        deck.addToDeck(new BaseAttackCard());
        deck.addToDeck(new BaseAttackCard());

        deck.addToDeck(new BaseDefenceCard());
        deck.addToDeck(new BaseDefenceCard());
        deck.addToDeck(new BaseDefenceCard());
        deck.addToDeck(new BaseDefenceCard());
        deck.addToDeck(new BaseDefenceCard());
        deck.addToDeck(new BaseDefenceCard());
        deck.addToDeck(new BaseDefenceCard());
        deck.addToDeck(new BaseDefenceCard());


        deck.shuffleDeck();

        deck.draw();

        System.out.println(deck.toString());

        deck.draw();

        System.out.println(deck.toString());

        deck.draw();

        System.out.println(deck.toString());

    }

}
