package com.alttabber.games.gameobjects;

import com.alttabber.games.gameobjects.player.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class SmithBlock {

    private Texture texture = new Texture(Gdx.files.internal("backgrounds/smith_block.png"));
    private float width;
    private float height;
    private float x, y;
    private Player player;
    private Stage stage;

    public SmithBlock(Player player, Stage stage) {
        this.width = texture.getWidth()/2;
        this.height = texture.getHeight()/2;
        x = 950;
        y = 400;
        this.player = player;
        this.stage = stage;
    }

    public void draw(Batch batch){
        batch.draw(texture, x, y, width, height);
        for(int i = 0; i<player.getDeck().getCraft().size(); i++){
            Card card = player.getDeck().getCraft().get(i);
            if(!card.isTouched) {
                card.setXY(x + 40 + (card.width + 20) * i, y + 50);
            }
            card.draw(batch);
            card.addToStage(stage);
        }
    }


}
