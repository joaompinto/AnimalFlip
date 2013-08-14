package org.osgameseed.games.animalflip.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;

import org.osgameseed.games.animalflip.AnimalFlipGame;
import org.osgameseed.games.animalflip.actors.GridBoard;

public class PlayScreen implements Screen {

    AnimalFlipGame game;
    Stage stage;
    GridBoard board;

    public PlayScreen(AnimalFlipGame game) {
        this.game = game;
    }

    @Override
    public void show() {

        board = new GridBoard();
        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        stage.addListener(board.new InputHandler());
        stage.addActor(board);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void render(float delta) {

        Camera camera = stage.getCamera();

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        stage.setViewport( width, height, true );
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



}
