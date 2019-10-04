package com.alttabber.games.gameobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    List<Card> hand;
    List<Card> graveyard;
    List<Card> discard;
    List<Card> deck;

    public Deck() {
        this.hand = new ArrayList<>();
        this.graveyard = new ArrayList<>();
        this.discard = new ArrayList<>();
        this.deck = new ArrayList<>();

    }

    public void addToDiscard(Card card){
        discard.add(card);
    }

    public void addToDeck(Card card){
        deck.add(card);
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

    public List<Card> draw(int num){
        List<Card> cards = new ArrayList<>();
        for(int i = 0; i < num; i++){
            cards.add(draw());
        }
        return cards;
    }

    public synchronized Card draw(){
        if(deck.size() == 0){
            deck.addAll(discard);
            shuffleDeck();
        }
        if(deck.size() == 0){
            //TODO ЧТО ДЕЛАТЬ?
            System.out.println("В колоде не осталось карт.");
            return null;
        }
        System.out.println(toString());
        hand.add(deck.remove(0));
        return hand.get(hand.size()-1);
    }

    @Override
    public String toString() {
        return "deck{" + Arrays.toString(deck.toArray()) + "}, \ndiscard[" + Arrays.toString(discard.toArray()) + "], \nhand[" + Arrays.toString(hand.toArray()) + "]";
    }
}
