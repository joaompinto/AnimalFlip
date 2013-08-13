package org.osgameseed.games.animalflip;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;



public class Assets {

    public static Array<Texture> animal_textures;

    public static void load () {

        animal_textures = new Array<Texture>();

        FileHandle dirHandle = Gdx.files.internal("data/animals");
        for (FileHandle entry: dirHandle.list()) {
            Texture texture = new Texture(entry);
            animal_textures.add(texture);
        }
    }
}