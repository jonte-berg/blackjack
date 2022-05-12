package BlackJack.model.rules;

public class RulesFactory {

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
  
  public IWinStrategy GetNewWinRule(){  
	    return new DealerWinStrategy();  
	  } 
  
  public IHitStrategy GetHitRule() {
	    return new Soft17Strategy();
	}
	
}
