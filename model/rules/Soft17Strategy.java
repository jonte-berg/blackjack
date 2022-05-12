package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Player;

class Soft17Strategy implements IHitStrategy {
	private final int g_17Limit = 17;

    public boolean DoHit(Player a_dealer) {
        int score = a_dealer.CalcScore();
       return score < g_17Limit || (score == g_17Limit && HasAce(a_dealer));
    }

    private boolean HasAce(Player a_dealer) {
        for(Card c: a_dealer.GetHand()) {
            if (c.GetValue() == Card.Value.Ace){
                return true;
            }
        }
               return false;
        
    }
}