package control;

import model.BlackCard;
import interfaces.Card;
import model.Client;
import model.GoldCard;

/**
 *
 * @author nathancezar
 */
public class CardFactory {

    private static CardFactory instance;

    public static CardFactory getCardFactory() {
        if (CardFactory.instance == null) {
            CardFactory.instance = new CardFactory();
        }
        return CardFactory.instance;
    }

    public Card getCard(Client client) {
        if (client.getIncome() >= 3000) {
            return new GoldCard(client.getName(), client.getIncome());
        } else {
            return new BlackCard(client.getName(), client.getIncome());
        }
    }
}
