package com.alttabber.games.cards;

import com.alttabber.games.gameobjects.Battle;
import com.alttabber.games.gameobjects.Card;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.UUID;

public class StickCard extends Card {

    private static Texture texture = new Texture(Gdx.files.internal("cards/01_Stick.png"));

    public StickCard() {
        this.name = "Stick";
        this.id = name + "-" + UUID.randomUUID();
        this.cardTexture = texture;
    }

    @Override
    public void play() {
        float damage = 1;
        damage = Battle.getCurrentBattle().getPlayer().calculateDamage(damage);
        Battle.getCurrentBattle().getEnemy().minusHp(damage);
    }
}
