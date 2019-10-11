package com.alttabber.games.cards;

import com.alttabber.games.gameobjects.Battle;
import com.alttabber.games.gameobjects.Card;
import com.alttabber.games.gameobjects.Consumable;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.UUID;

@Consumable(card1 = WaterCard.class, card2 = HerbsCard.class)
public class HealingPotionCard extends Card {

    private static Texture texture = new Texture(Gdx.files.internal("cards/05_HealingPotion.png"));

    public HealingPotionCard() {
        this.name = "HealingPotion";
        this.id = name + "-" + UUID.randomUUID();
        this.cardTexture = texture;
    }

    @Override
    public void play() {
        Battle.getCurrentBattle().getPlayer().healHp(5);
        Battle.getCurrentBattle().getPlayer().getDeck().destroyCard(this);
    }
}
