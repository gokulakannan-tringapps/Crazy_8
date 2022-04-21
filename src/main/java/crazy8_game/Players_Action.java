package crazy8_game;
import java.util.*;
public class Players_Action extends PlayerTurn {
				
				/*Constructor to assign cards for each players*/
				Players_Action(List<Card> deck,int id){
					playerId=id;
					for(int i=0;i<7;i++) {
						play_Cards.add(deck.get(0));
						deck.remove(0);
					}
					for(int i=0;i<7;i++) {
						System.out.print(play_Cards.get(i).getSuit()+" "+play_Cards.get(i).getRank()+", ");
					}
				}
				
				
				public void ChangeSuit() {
					int clubs=0,diamonds=0,spades=0,hearts=0;
					
					System.out.println("Player "+this.playerId+" have "+this.TopCard.getSuit()+" "+ this.TopCard.getRank());
					for(int i=0;i<this.play_Cards.size();i++) {
						if(this.play_Cards.get(i).getSuit().equals(Card.Suit.CLUBS)) {
							clubs++;
						}
						else if(this.play_Cards.get(i).getSuit().equals(Card.Suit.DIAMONDS)) {
							diamonds++;
						}
						else if(this.play_Cards.get(i).getSuit().equals(Card.Suit.SPADES)) {
							spades++;
						}
						else {
							hearts++;
						}
					}
					
					if(clubs>diamonds && clubs>spades && clubs>hearts) {
						this.ChangeSuit=Card.Suit.CLUBS;
					}
					else if(diamonds>clubs && diamonds>spades && diamonds>hearts) {
						this.ChangeSuit=Card.Suit.DIAMONDS;
					}
					else if(spades>diamonds && spades>clubs && spades>hearts) {
						this.ChangeSuit=Card.Suit.SPADES;
					}
					else {
						this.ChangeSuit=Card.Suit.HEARTS;
					}
					System.out.println("Player "+this.playerId+" chosen "+this.changeSuit);
				}
				
				
				/*play() method will compare player cards with top card and return true if available or return false*/
				/*If player have No 8 card, it calls sub method changesuit()*/
				public boolean play() {
					for(int i=0;i<this.play_Cards.size();i++) {
					  if(this.play_Cards.get(i).getSuit().equals(this.TopCard.getSuit()) || this.play_Cards.get(i).getRank().equals(this.TopCard.getRank()) || this.play_Cards.get(i).getRank().equals(Card.Rank.EIGHT)) {
										this.TopCard=this.play_Cards.get(i);
										System.out.println("Player "+this.playerId+" Turns.."+this.TopCard.getSuit()+" "+this.TopCard.getRank());
										this.play_Cards.remove(i);
										return true;
						}
					}
					return false;
				}
				
				/*drawFromDeck() will provide cards for players if they do not have any match*/
				public boolean drawFromDeck(List<Card> Deck) {
						int i=0,count=0;
						boolean available=false;
						while(i<3 && available==false) {
								this.play_Cards.add(Deck.get(0));
								count++;
								if(Deck.get(0).getRank().equals(TopCard.getRank()) || Deck.get(0).getSuit().equals(TopCard.getSuit())  ) {
									available=true;
									System.out.println("Available for Player "+this.playerId);
									System.out.println("Available at "+count+" times");
								}
								if(Deck.get(0).getRank()== Card.Rank.EIGHT) {
									available=true;
									return true;
								}
								i++;
								Deck.remove(0);
						}
						if(available==false) {
							System.out.println("Player "+this.playerId+" do not have match , so he pass");
						}
						return false;
				}
}
