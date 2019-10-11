package com.alttabber.games.screens;

import com.alttabber.games.CardGame;
import com.alttabber.games.gameobjects.Battle;
import com.alttabber.games.gameobjects.BattleUI;
import com.alttabber.games.gameobjects.CardFactory;
import com.alttabber.games.gameobjects.HandContainer;
import com.alttabber.games.gameobjects.enemies.EnemyGenerator;
import com.alttabber.games.gameobjects.player.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.lang.reflect.InvocationTargetException;

public class BattleScreen implements Screen {

    private SpriteBatch batch;
    private OrthographicCamera camera;

    Texture texture = new Texture(Gdx.files.internal("backgrounds/Background.png"));
    Image background;

    BattleUI battleUI;

    Stage stage;

    Player player;

    public BattleScreen(CardGame game) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        background = new Image(texture);
        background.setWidth(Gdx.graphics.getWidth());
        background.setHeight(Gdx.graphics.getHeight());

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        player = new Player();

        CardFactory.initCards();
        CardFactory.initCraftable();

        for(int i = 0 ; i < 30; i++) {
            player.getDeck().addToDeck(CardFactory.getRandomCard());
        }

        battleUI = new BattleUI(player, stage);

        EnemyGenerator.initEnemyGenerator(player);
        Battle battle = new Battle(player, EnemyGenerator.nextEnemy(), battleUI);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        background.draw(batch, 1.0f);

        battleUI.draw(batch);

        Battle.getCurrentBattle().getEnemy().draw(batch);

        batch.end();
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
