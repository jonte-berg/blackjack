package BlackJack.model.rules;

import BlackJack.model.Player;

public class PlayerWinStrategy implements IWinStrategy {

	@Override
	public boolean IsDealerWinner(Player a_player, Player a_dealer, int g_maxScore) {
		if(a_dealer.CalcScore() > g_maxScore) { return true; } 
		if(a_player.CalcScore() > g_maxScore) { return false; } 
		
		return a_dealer.CalcScore() >= a_player.CalcScore();
	}
	}