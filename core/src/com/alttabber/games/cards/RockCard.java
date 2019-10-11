package com.alttabber.games.cards;

import com.alttabber.games.gameobjects.Battle;
import com.alttabber.games.gameobjects.Card;
import com.alttabber.games.gameobjects.Consumable;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.UUID;

@Consumable(card1 = WaterCard.class, card2 = MushroomCard.class)
public class RockCard extends Card {

    //TODO
    private static Texture texture = new Texture(Gdx.files.internal("cards/03_AttackPotion.png"));

    public RockCard() {
        this.name = "AttackPotion";
        this.id = name + "-" + UUID.randomUUID();
        this.cardTexture = texture;
    }

    @Override
    public void play() {
        Battle.getCurrentBattle().getPlayer().addAttack(3);
        Battle.getCurrentBattle().getPlayer().getDeck().destroyCard(this);
    }

}
