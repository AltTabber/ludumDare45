package com.alttabber.games.gameobjects;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> hand;
    private List<Card> graveyard;
    private List<Card> discard;
    private List<Card> deck;
    private List<Card> craft;

    public Deck() {
        this.hand = new ArrayList<>();
        this.graveyard = new ArrayList<>();
        this.discard = new ArrayList<>();
        this.deck = new ArrayList<>();
        this.craft = new ArrayList<>();
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
            deck.addAll(discard);
            discard.clear();
            System.out.println("В колоде не осталось карт. " + deck.toString());
            return null;
        }
        if(hand.size() >= 10){
            discard.add(deck.remove(0));
            return null;
        }
        hand.add(deck.remove(0));
        return hand.get(hand.size()-1);
    }

    public synchronized void playCard(Card card){
        hand.remove(card);
        discard.add(card);
    }

    public void destroyCard(Card card) {
        hand.remove(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public List<Card> getCraft() {
        return craft;
    }

    @Override
    public String toString() {
        return "deck{" + Arrays.toString(deck.toArray()) + "}, \ndiscard[" + Arrays.toString(discard.toArray()) + "], " +
                "\nhand[" + Arrays.toString(hand.toArray()) + "], \ncraft[" + Arrays.toString(craft.toArray()) + "]";
    }

    public void moveToCraft(Card card) {
        if(craft.size() < 2) {
            hand.remove(card);
            craft.add(card);
        }
    }

    public void addToHand(Card card) {
        if(!hand.contains(card)){
            hand.add(card);
            removeFromCraft(card);
        }
    }

    public void removeFromCraft(Card card){
        if(craft.contains(card))
            craft.remove(card);
    }

    public void craftCard() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if(craft.size() == 2) {
            Class<? extends Card> cardClass = CardFactory.getCraftedCard(craft.get(0), craft.get(1));
            Card card = cardClass.getConstructor().newInstance();
            //card.setDefaultListeners();
            for(Card cardDestroyed : craft)
                cardDestroyed.clear();
            craft.clear();
            moveToCraft(card);
        }
        System.out.println(toString());;
    }
}
