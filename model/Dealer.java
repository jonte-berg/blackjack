package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinStrategy m_winStrategy;  

  public Dealer(RulesFactory a_rulesFactory) {
  
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    m_winStrategy = a_rulesFactory.GetNewWinRule();  
    
    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
  }
  
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(this, a_player);   
    }
    return false;
  }
  
  
  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
      giveCard(a_player,true); 
      
      return true;
    }
    return false;
  }

  public boolean IsDealerWinner(Player a_player) {
   return m_winStrategy.IsDealerWinner(a_player, this, g_maxScore); 
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }
  
  public boolean Stand(){
	    if (m_deck != null) {
	      ShowHand();
	    while(m_hitRule.DoHit(this)) {
	        giveCard(this,true);
	      }
	    return true; 
	    }
	    return false; 
	  }
  
  public void giveCard(Player a_player, Boolean isVisible){ 
		Card c = m_deck.GetCard();
		c.Show(isVisible);
	  a_player.DealCard(c);
  }
  
 
  
  
  
  
}
