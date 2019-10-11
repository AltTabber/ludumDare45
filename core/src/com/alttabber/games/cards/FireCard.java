package com.alttabber.games.cards;

import com.alttabber.games.gameobjects.Battle;
import com.alttabber.games.gameobjects.Card;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.UUID;

public class FireCard extends Card {

    private static Texture texture = new Texture(Gdx.files.internal("cards/07_Fire.png"));

    public FireCard() {
        this.name = "Fire";
        this.id = name + "-" + UUID.randomUUID();
        this.cardTexture = texture;
    }

    @Override
    public void play() {
        float damage = 1;
        damage = Battle.getCurrentBattle().getPlayer().calculateDamage(damage);
        Battle.getCurrentBattle().getEnemy().minusHp(damage);
        Battle.getCurrentBattle().getPlayer().getDeck().destroyCard(this);
    }

}
