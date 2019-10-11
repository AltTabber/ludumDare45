package com.alttabber.games.gameobjects;

import com.alttabber.games.gameobjects.player.Player;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.List;

public class HandContainer {

    Player player;
    Stage stage;
    float width;
    float maxDelta;
    float maxCountWithoutDelta;

    public HandContainer(Player player, Stage stage) {
        this.player = player;
        this.stage = stage;

        this.width = 600;
        this.maxDelta = 5;
        this.maxCountWithoutDelta = 4;
    }


    public void draw(Batch batch, int x, int y) {
        List<Card> hand = player.getDeck().getHand();
        if(hand.size() <= maxCountWithoutDelta){
            for(int i = 0; i< hand.size(); i++ ){
                Card card = player.getDeck().getHand().get(i);
                card.addToStage(stage);
                float _x = x + this.width - ((Card.getWidth() * i) + maxDelta * (i - 1));
                float _y = y;
                if(!card.isTouched) {
                    card.setXY(_x, _y);
                }
                card.draw(batch);
            }
        }else{
            float delta = (this.width/2 - (Card.getWidth() * hand.size())/2) / (hand.size() - 1);
            for(int i = 0; i < hand.size(); i++){
                Card card = player.getDeck().getHand().get(i);
                card.addToStage(stage);
                float _x = x + this.width - ((Card.getWidth() * i) + delta * (i - 1));
                float _y = y;
                if(!card.isTouched) {
                    card.setXY(_x, _y);
                }
                card.draw(batch);
            }
        }

    }
}
