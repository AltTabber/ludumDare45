package com.alttabber.games.screens;

import com.alttabber.games.CardGame;
import com.alttabber.games.cards.BaseAttackCard;
import com.alttabber.games.gameobjects.HandContainer;
import com.alttabber.games.gameobjects.player.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BattleScreen implements Screen {

    final CardGame game;
    public SpriteBatch batch;
    private OrthographicCamera camera;

    public BaseAttackCard card;

    public Player player;
    private HandContainer handContainer;

    public BattleScreen(final CardGame game) {
        this.game = game;
        card = new BaseAttackCard();
        batch = new SpriteBatch();
        batch.enableBlending();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);

        player = new Player();
        handContainer = new HandContainer(player);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.begin();

//        card.draw(batch, 0, 0);
        handContainer.draw(batch, 200, -10);

        batch.end();

        if(Gdx.input.justTouched()){
            player.getDeck().draw();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
