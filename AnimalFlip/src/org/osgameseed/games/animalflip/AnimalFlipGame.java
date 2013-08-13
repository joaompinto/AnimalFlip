package org.osgameseed.games.animalflip;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;

import org.osgameseed.games.animalflip.screens.PlayScreen;

public class AnimalFlipGame extends Game {

    @Override
    public void create() {
        Texture.setEnforcePotImages(false); // Stop forcing the power of two texture dimensions
        Assets.load();
        setScreen(new PlayScreen(this));
    }
}