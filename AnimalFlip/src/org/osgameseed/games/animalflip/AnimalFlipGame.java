package org.osgameseed.games.animalflip;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

import org.osgameseed.games.animalflip.screens.PlayScreen;

public class AnimalFlipGame extends Game {

    @Override
    public void create() {
        Texture.setEnforcePotImages(false); // Stop forcing the power of two texture dimensions
        Assets.load();
        //FileHandle applIconFile = Gdx.files.internal("data/icon.png");
        //Pixmap applIcon = new Pixmap(applIconFile);
        Gdx.graphics.setTitle("Animal Flip");
        setScreen(new PlayScreen(this));
    }
}