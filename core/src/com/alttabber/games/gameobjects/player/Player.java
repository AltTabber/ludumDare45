package com.alttabber.games.gameobjects.player;

import com.alttabber.games.gameobjects.Card;
import com.alttabber.games.gameobjects.Deck;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Player {

    private Integer hp;
    private Integer mp;
    private PlayerState playerState;
    private Deck deck;

    public Player() {
        this.hp = 30;
        this.mp = 3;
        playerState = PlayerState.ALIVE;
        deck = new Deck();
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void draw(Batch batch) {
    }

    public float calculateDamage(float damage) {
        //TODO
        return damage;
    }

    public void addAttack(float i) {
        //TODO
    }

    public void addArmor(float i) {
        //TODO
    }

    public void healHp(float i) {
        //TODO
    }

    public void minusHP(float i) {
        //TODO
    }

    public void clearEffects() {
        //TODO
    }

    public void addToHand(Card card) {
        deck.addToHand(card);
    }
}
