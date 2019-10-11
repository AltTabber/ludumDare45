package com.alttabber.games.gameobjects.enemies;

import com.alttabber.games.gameobjects.Battle;
import com.alttabber.games.text.TextContainer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Enemy {

    protected Texture enemyTexture;
    protected String name;
    protected String id;
    protected float width;
    protected float height;

    protected float x;
    protected float y;

    protected float maxHp;
    protected float hp;

    protected ProgressBar hpBar;
    protected ProgressBar.ProgressBarStyle hpBarStyle;
    protected float widthHpBar;

    protected List<EnemyAction> actions;

    protected EnemyState state = EnemyState.ALIVE;


    public Enemy() {
        this.name = "UndefinedEnemy";
        this.id = name + "-" + UUID.randomUUID();

        Skin skin = new Skin();
        Pixmap pixmap = new Pixmap(1, 8, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("white", new Texture(pixmap));

        this.hpBarStyle = new ProgressBar.ProgressBarStyle(skin.newDrawable("white", Color.DARK_GRAY), skin.newDrawable("white", Color.DARK_GRAY));
        this.hpBarStyle.knobBefore = skin.newDrawable("white",new Color(0xce4d53ff));

        actions = new ArrayList<>();
    }

    public void draw(Batch batch){
        if(state == EnemyState.ALIVE) {
            batch.draw(enemyTexture, x, y, width, height);
            hpBar.setValue(hp);
            hpBar.draw(batch, 1.f);
            TextContainer.getLayout().setText(TextContainer.getHeaderLabelFont(), this.name);
            TextContainer.getHeaderLabelFont().draw(batch, this.name, this.x + widthHpBar / 2 - TextContainer.getLayout().width, hpBar.getY()+25);
        }
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public abstract void doAction();

    public void minusHp(float hp){
        this.hp -= hp;
        if(this.hp <= 0){
            destroy();
            this.hp = 0;
        }
    }

    public void destroy(){
        state = EnemyState.DEAD;
        Battle.getCurrentBattle().endBattle();
    }

    public EnemyState getState() {
        return state;
    }

    public enum EnemyState{
        ALIVE,
        DEAD
    }
}
