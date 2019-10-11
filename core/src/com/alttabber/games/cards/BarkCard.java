package com.alttabber.games.cards;

import com.alttabber.games.gameobjects.Battle;
import com.alttabber.games.gameobjects.Card;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.UUID;


public class BarkCard extends Card {

    private static Texture texture = new Texture(Gdx.files.internal("cards/04_Bark.png"));

    public BarkCard() {
        this.name = "Bark";
        this.id = name + "-" + UUID.randomUUID();
        this.cardTexture = texture;
    }

    @Override
    public void play() {
        Battle.getCurrentBattle().getPlayer().addArmor(1);
    }

}
