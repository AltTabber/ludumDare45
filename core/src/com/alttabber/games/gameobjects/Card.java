package com.alttabber.games.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import java.awt.*;
import java.util.UUID;

public class Card implements Drawable {

    protected Integer basicCost;
    protected String id;
    protected String name = "Error_card";
    protected Texture cardTexture;
    protected Rectangle rect;

    public Card() {
        basicCost = 0;
        this.id = name + "-" + UUID.randomUUID();
        this.rect = new Rectangle();
        this.rect.height = 1366/6;
        this.rect.width = 768/6;
    }

    @Override
    public String toString() {
        return "Card{id='" + id + "}";
    }

    @Override
    public void draw(Batch batch, float x, float y, float width, float height) {
        batch.draw(cardTexture, x, y, width, height);
        this.rect.x = (int) Math.floor(x);
        this.rect.y = (int) Math.floor(y);
    }

    public void draw(Batch batch, float x, float y){
        draw(batch, x, y, this.rect.width, this.rect.height);
    }

    @Override
    public float getLeftWidth() {
        return 0;
    }

    @Override
    public void setLeftWidth(float leftWidth) {

    }

    @Override
    public float getRightWidth() {
        return 0;
    }

    @Override
    public void setRightWidth(float rightWidth) {

    }

    @Override
    public float getTopHeight() {
        return 0;
    }

    @Override
    public void setTopHeight(float topHeight) {

    }

    @Override
    public float getBottomHeight() {
        return 0;
    }

    @Override
    public void setBottomHeight(float bottomHeight) {

    }

    @Override
    public float getMinWidth() {
        return 0;
    }

    @Override
    public void setMinWidth(float minWidth) {

    }

    @Override
    public float getMinHeight() {
        return 0;
    }

    @Override
    public void setMinHeight(float minHeight) {

    }
}
