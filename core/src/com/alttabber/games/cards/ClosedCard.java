package com.alttabber.games.cards;

import com.alttabber.games.gameobjects.Card;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.UUID;

public class ClosedCard extends Card {

    private static Texture texture = new Texture(Gdx.files.internal("cards/00_Shirt.png"));

    public ClosedCard() {
        this.name = "Closed";
        this.id = name + "-" + UUID.randomUUID();
        this.cardTexture = texture;
    }

    @Override
    public void play() {
        //TODO
    }

}
