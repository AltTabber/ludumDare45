package com.alttabber.games.text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

public class Button {

    String text;

    private static Texture btn9Patch = new Texture(Gdx.files.internal("buttons/button9Patch.png"));
    private BitmapFont font = TextContainer.getButtonFont();
    private NinePatch ninePatch;
    private TextButton.TextButtonStyle style;
    private TextButton button;


    private Stage stage;

    private float x = 0;
    private float y = 0;

    public Button(String text, Stage stage) {


        this.text = text;
        font.setColor(Color.NAVY);
        ninePatch = new NinePatch(btn9Patch, 30, 30, 30, 30);
        ninePatch.scale(0.35f, 0.35f);
        NinePatchDrawable btnNormal9Drawable = new NinePatchDrawable(ninePatch);

        style = new TextButton.TextButtonStyle(btnNormal9Drawable, btnNormal9Drawable, btnNormal9Drawable,  font);


        button = new TextButton(text, style);

        stage.addActor(button);
    }

    public void draw(Batch batch){

        button.setPosition(x, y);
        button.draw(batch, 1.f);
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void addListener(EventListener listener) {
        button.addListener(listener);
    }

    public void clearListeners() {
        button.clearListeners();
    }
}
