package BlackJack.model.rules;

import BlackJack.model.Player;

public class DealerWinStrategy implements IWinStrategy {

	@Override
	public boolean IsDealerWinner(Player a_player, Player a_dealer, int g_maxScore) {
		if(a_dealer.CalcScore() > g_maxScore) { return false; } 
		if(a_player.CalcScore() > g_maxScore) { return true; } 
		
		return a_dealer.CalcScore() >= a_player.CalcScore();
	}

}