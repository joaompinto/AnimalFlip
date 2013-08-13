package org.osgameseed.games.animalflip.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;

import org.osgameseed.games.animalflip.AnimalFlipGame;
import org.osgameseed.games.animalflip.InputHandler;
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
        InputHandler inputHandler = new InputHandler(board);

        Gdx.input.setInputProcessor(stage);


        stage.addListener(inputHandler);
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

        /*
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        Iterator<Integer> iter = cards_grid.iterator();
        int count = 0;
        while(iter.hasNext()) {
            int card_i = iter.next();
            float left_margin = 20;
            float top_margin = (h/2)-200;
            float x_pos = left_margin+(-w/2)+(count % 5)*155;
            float y_pos = top_margin-(count / 5)*150;
            //Sprite sprite = animals_sprites.get(card_i);
            //sprite.setScale(1);
            //sprite.setPosition(x_pos, y_pos);
            //sprite.draw(batch);
            ++count;
        }
        batch.end();


        // process user input
        if(Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            System.out.print(touchPos.x);
        }*/
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
