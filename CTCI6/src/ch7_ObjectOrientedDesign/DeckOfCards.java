package ch7_ObjectOrientedDesign;

import java.util.ArrayList;

public class DeckOfCards {

}

enum Suit
{
	Club(0), Diamond(1), Heart(2), Spade(3);
	
	private int value;
	
	private Suit(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public static Suit getSuitFromValue(int value)
	{
		if(value == 0)
			return Suit.Club;
		else if(value == 1)
			return Suit.Diamond;
		else if(value == 2)
			return Suit.Heart;
		else if(value == 3)
			return Suit.Spade;
		else
			return null;
	}
}

abstract class Card{
	
	protected int faceValue;
	protected Suit suit;
	private boolean availble = true;
	
	public Card(int value, Suit s)
	{
		faceValue = value;
		suit =s;
	}
	
	public boolean isAvailable()
	{
		return this.availble;
	}
	
	public void markAvailable()
	{
		availble = true;
	}
	
	public void markUnavailable()
	{
		availble = false;
	}
	
	public Suit suit()
	{
		return this.suit;
	}
	
	abstract int value();
}

class Deck<T extends Card>
{
	private ArrayList<T> cards;
	private int dealIndex;
	
	public void setDesk(ArrayList<T> deck)
	{
		
	}
	public T getCard()
	{
		return null;
	}
	
	public T[] getCards(int number)
	{
		return null;
	}
	
	public int remainingCards()
	{
		return cards.size() - dealIndex;
	}
}

class Hand<T extends Card>
{
	protected ArrayList<T> cards = new ArrayList<T>();
	
	public int score()
	{
		int score = 0;
		for(Card card: cards)
		{
			score += card.value();
		}
		
		return score;
	}
	
	public void addCard(T card)
	{
		cards.add(card);
	}
}

class BlackJackCard extends Card
{

	public BlackJackCard(int value, Suit s) {
		super(value, s);
	}

	@Override
	int value() {
		if(faceValue == 1)
			return 1;
		else if(faceValue>=11 && faceValue <= 13)
			return 10;
		else
			return faceValue;
	}
	
	public int minValue()
	{
		if(faceValue == 1)
			return 1;
		return value();
	}
	
	public int maxValue()
	{
		if(faceValue == 1)
			return 11;
		return value();
	}
	
	public boolean isFaceCard()
	{
		return faceValue >= 11 && faceValue <= 13;
	}
	
}

class BlackJackHand extends Hand<BlackJackCard>
{
	public int value()
	{
		ArrayList<Integer> scores = possibleSocres();
		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;
		for(int score : scores)
		{
			if(score>21 && score < minOver)
				minOver = score;
			else if(score<=21&& score> maxUnder)
				maxUnder = score;
		}
		return maxUnder == Integer.MIN_VALUE? minOver : maxUnder;
	}
	
	private ArrayList<Integer> possibleSocres()
	{
		return null;
	}
	
	public boolean busted()
	{
		return score() > 21;
	}
	
	public boolean is21()
	{
		return score() == 21;
	}
	
	public boolean isBlackJack()
	{
		return false;
	}
}
