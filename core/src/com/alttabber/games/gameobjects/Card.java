package com.alttabber.games.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import java.util.UUID;

public abstract class Card {

    protected Integer basicCost;
    protected String id;
    protected String name = "Error_card";
    protected Texture cardTexture;
    protected Image image;

    protected static float height = 1366 / 6;
    protected static float width = 768 / 6;

    private Stage stage;

    protected boolean isTouched = false;
    protected boolean isFromCraft = false;

    public Card() {
        basicCost = 0;
        this.id = name + "-" + UUID.randomUUID();
    }

    public void initImage() {
        if (image == null) {
            image = new Image(cardTexture);
            image.setWidth(width);
            image.setHeight(height);
            setDefaultListeners();
        }
    }

    public void setCardListener(EventListener listener) {
        initImage();
        image.addListener(listener);
        image.addCaptureListener(listener);
    }

    public void setDefaultListeners() {


        setCardListener(new DragListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                isTouched = true;
                Card.this.image.moveBy(x - image.getWidth() / 2, y - image.getHeight() / 2);

                if(ActionBlocks.getEnemyBlockRect().contains(Gdx.input.getX(), Gdx.input.getY())){
                    Card.this.setColor(0.7f, 0.f, 0.f, 0.5f);
                }else if(ActionBlocks.getCraftBlockRect().contains(Gdx.input.getX(), Gdx.input.getY())){
                    Card.this.setColor(0.f, 0.7f, 0.f, 0.5f);
                }else{
                    Card.this.setColor(1.f, 1.f, 1.f, 0.5f);
                }
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if(ActionBlocks.getEnemyBlockRect().contains(Gdx.input.getX(), Gdx.input.getY())){
                    Card.this.setColor(1.f, 1.f, 1.f, 1.f);
                    Battle.getCurrentBattle().playCard(Card.this);
                }else if(ActionBlocks.getCraftBlockRect().contains(Gdx.input.getX(), Gdx.input.getY())){
                    Card.this.setColor(1.f, 1.f, 1.f, 1.f);
                    Battle.getCurrentBattle().addToCraft(Card.this);
                }else{
                    Card.this.setColor(1.f, 1.f, 1.f, 1.f);
                    Battle.getCurrentBattle().addToHand(Card.this);
                }
                isTouched = false;
                super.touchUp(event, x, y, pointer, button);
            }
        });

    }

    public void setColor(float r, float g, float b, float a){
        this.image.setColor(r, g, b, a);
    }

    public abstract void play();

    public void clear(){
        image.clearListeners();
    }

    @Override
    public String toString() {
        return "Card{id='" + id + "}";
    }

    public void addToStage(Stage stage) {
        this.stage = stage;
        initImage();
        this.stage.addActor(image);
    }

    public void draw(Batch batch, float x, float y, float width, float height) {

        initImage();
        image.setX(x);
        image.setY(y);
        this.image.draw(batch, 1);

    }

    public void draw(Batch batch, float x, float y) {
        draw(batch, x, y, width, height);
    }

    public void draw(Batch batch) {
        draw(batch, image.getX(), image.getY(), width, height);
    }

    public void setXY(float x, float y) {
        initImage();
        image.setX(x);
        image.setY(y);
    }

    public float getX(){
        return image.getX();
    }

    public float getY(){
        return image.getY();
    }

    public void clearListeners() {
        image.clearListeners();
    }

    public float getHeight() {
        return height;
    }

    public static float getWidth() {
        return width;
    }
}
