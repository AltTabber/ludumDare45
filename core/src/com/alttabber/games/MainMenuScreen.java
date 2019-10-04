package com.alttabber.games;

import com.alttabber.games.screens.BattleScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MainMenuScreen implements Screen {

    final CardGame game;

    OrthographicCamera camera;

    Stage stage;

    BitmapFont menuFont;
    TextButton.TextButtonStyle menuButtonStyle;

    Table buttonTable;

    TextButton newGameButton;
    TextButton optionsButton;
    TextButton exitButton;


    public MainMenuScreen(final CardGame game) {
        this.game = game;

        this.stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        menuFont = new BitmapFont();

        menuButtonStyle = new TextButton.TextButtonStyle();
        menuButtonStyle.font = menuFont;
        menuButtonStyle.downFontColor = Color.BLUE;


        newGameButton = new TextButton("Start Hunt!", menuButtonStyle);
        newGameButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                newGameButton.remove();
                optionsButton.remove();
                exitButton.remove();
                game.setScreen(new BattleScreen(game));
            }
        });


        optionsButton = new TextButton("Options", menuButtonStyle);


        exitButton = new TextButton("Exit", menuButtonStyle);
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.dispose();
                Gdx.app.exit();
//                System.exit(0);
            }
        });

        buttonTable = new Table();

        buttonTable.add(newGameButton);
        buttonTable.row();
        buttonTable.add(optionsButton);
        buttonTable.row();
        buttonTable.add(exitButton);

        stage.addActor(buttonTable);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.end();

        stage.draw();

        buttonTable.setPosition(640, 300);


//        if(Gdx.input.isTouched()){
//            game.setScreen(new GameScreen(game));
//
//            dispose();
//        }
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
