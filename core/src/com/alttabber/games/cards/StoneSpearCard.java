package com.alttabber.games.cards;

import com.alttabber.games.gameobjects.Battle;
import com.alttabber.games.gameobjects.Card;
import com.alttabber.games.gameobjects.Consumable;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.UUID;

@Consumable(card1 = RockCard.class, card2 = StickCard.class)
public class StoneSpearCard extends Card {

    private static Texture texture = new Texture(Gdx.files.internal("cards/01_Spear.png"));

    public StoneSpearCard(){
        this.name = "StoneSpear";
        this.id = name + "-" + UUID.randomUUID();
        this.cardTexture = texture;
    }

    @Override
    public void play() {
        float damage = 3;
        damage = Battle.getCurrentBattle().getPlayer().calculateDamage(damage);
        Battle.getCurrentBattle().getEnemy().minusHp(damage);
        Battle.getCurrentBattle().getPlayer().getDeck().playCard(this);
    }
}
