package com.alttabber.games.cards;

import com.alttabber.games.gameobjects.Card;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import java.util.UUID;

public class BaseAttackCard extends Card {

    private static Texture texture = new Texture(Gdx.files.internal("cards/02_AttackPunch.png"));

    public BaseAttackCard() {
        this.basicCost = 1;
        this.name = "BaseAttackCard";
        this.id = name + "-" + UUID.randomUUID();
        this.cardTexture = texture;
    }

}
