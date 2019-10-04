package com.alttabber.games.gameobjects.player;

import com.alttabber.games.cards.BaseAttackCard;
import com.alttabber.games.cards.BaseDefenceCard;
import com.alttabber.games.gameobjects.Deck;

import java.util.ArrayList;

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
        deck.addToDeck(new BaseAttackCard());
        deck.addToDeck(new BaseAttackCard());
        deck.addToDeck(new BaseAttackCard());
        deck.addToDeck(new BaseAttackCard());
        deck.addToDeck(new BaseAttackCard());
        deck.addToDeck(new BaseDefenceCard());
        deck.addToDeck(new BaseDefenceCard());
        deck.addToDeck(new BaseDefenceCard());
        deck.addToDeck(new BaseDefenceCard());
        deck.addToDeck(new BaseDefenceCard());
        deck.shuffleDeck();
    }

    public Deck getDeck() {
        return deck;
    }
}
