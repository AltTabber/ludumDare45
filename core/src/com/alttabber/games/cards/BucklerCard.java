package com.alttabber.games.cards;

import com.alttabber.games.gameobjects.Battle;
import com.alttabber.games.gameobjects.Card;
import com.alttabber.games.gameobjects.Consumable;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.UUID;

@Consumable(card1 = BarkCard.class, card2 = IronOreCard.class)
public class BucklerCard extends Card {

    private static Texture texture = new Texture(Gdx.files.internal("cards/07_Buckler.png"));

    public BucklerCard() {
        this.name = "Buckler";
        this.id = name + "-" + UUID.randomUUID();
        this.cardTexture = texture;
    }

    @Override
    public void play() {
        Battle.getCurrentBattle().getPlayer().addArmor(5);
    }
}
