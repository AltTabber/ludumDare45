package com.alttabber.games.cards;

import com.alttabber.games.gameobjects.Card;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.UUID;

public class BaseDefenceCard extends Card{

    private static Texture texture = new Texture(Gdx.files.internal("cards/01_Block.png"));

    public BaseDefenceCard() {
        this.basicCost = 1;
        this.name = "BaseDefenceCard";
        this.id = name + "-" + UUID.randomUUID();
        this.cardTexture = texture;
    }

}
