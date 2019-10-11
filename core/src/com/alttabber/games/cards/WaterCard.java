package com.alttabber.games.cards;

import com.alttabber.games.gameobjects.Battle;
import com.alttabber.games.gameobjects.Card;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.UUID;

public class WaterCard extends Card {

    private static Texture texture = new Texture(Gdx.files.internal("cards/06_Water.png"));

    public WaterCard() {
        this.name = "Water";
        this.id = name + "-" + UUID.randomUUID();
        this.cardTexture = texture;
    }

    @Override
    public void play() {
        Battle.getCurrentBattle().getPlayer().healHp(1);
    }

}
