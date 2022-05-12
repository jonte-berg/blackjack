package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;
import BlackJack.model.IObserver;

public class PlayGame implements IObserver {
	private IView a_view; 
	private Game a_game; 
	
	
	public PlayGame(Game a_game, IView a_view) {
		this.a_view = a_view;
		this.a_game = a_game;
		Subscribe(this);
}

  public boolean Play(Game a_game, IView a_view) {
    a_view.DisplayWelcomeMessage();
    
    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

    if (a_game.IsGameOver())
    {
        a_view.DisplayGameOver(a_game.IsDealerWinner());
    }

   IView.Choices input = a_view.GetInput();
    
 switch(input){ 
 case Play: 
	 a_game.NewGame();
	 break; 
	 
 case Stand:
	 a_game.Stand();
	 break; 
	 
 case Hit: 
	 a_game.Hit();
	 break; 
	 
 case Quit:
	 return false; 
	 
 }
 return true; 
}

@Override
public void GetNewCard() {
	a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
	try{
		Thread.sleep(1800);
	}catch (InterruptedException e) {
		e.printStackTrace();
	}
	if (a_game.IsGameOver()) {
		a_view.DisplayGameOver(a_game.IsDealerWinner());
}
	a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
	
	try{
		Thread.sleep(1800);
	}catch (InterruptedException e) {
		e.printStackTrace();
	}
	if (a_game.IsGameOver()) {
		a_view.DisplayGameOver(a_game.IsDealerWinner());
	}
	

	
}
public void Subscribe(IObserver a_subscriber){ 
	this.a_game.AddSubscriber(a_subscriber); 
}

}
 
