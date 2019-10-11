package com.alttabber.games.cards;

import com.alttabber.games.gameobjects.Battle;
import com.alttabber.games.gameobjects.Card;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.UUID;

public class HerbsCard extends Card {

    private static Texture texture = new Texture(Gdx.files.internal("cards/03_Herbs.png"));

    public HerbsCard() {
        this.name = "Herbs";
        this.id = name + "-" + UUID.randomUUID();
        this.cardTexture = texture;
    }

    @Override
    public void play() {
        Battle.getCurrentBattle().getPlayer().healHp(1);
        Battle.getCurrentBattle().getPlayer().getDeck().destroyCard(this);
    }

}
