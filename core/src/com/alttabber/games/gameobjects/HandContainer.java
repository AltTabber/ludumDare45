package com.alttabber.games.gameobjects;

import com.alttabber.games.gameobjects.player.Player;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import java.util.List;

public class HandContainer implements Drawable {

    private Player player;
    private float width;

    public HandContainer(Player player){
        this.player = player;
        this.width = 900;
    }


    @Override
    public void draw(Batch batch, float x, float y, float width, float height) {
        this.width = width;
        List<Card> handCards = player.getDeck().hand;
        for(int i = 0; i < handCards.size(); i++){
            Card card = handCards.get(i);
            float _x = x + i*(this.width - card.rect.width)/handCards.size();
            float _y = y;
            card.draw(batch, _x, _y, card.rect.width, card.rect.height);
        }
    }

    public void draw(Batch batch, float x, float y){
        draw(batch, x, y, this.width, 0);
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
