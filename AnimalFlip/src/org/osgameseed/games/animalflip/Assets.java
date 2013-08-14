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
        String[] animal_list = {"monkey.png"
            , "dragon.png"
            , "mouse.png"
            , "pig.png"
            , "dog.png"
            , "bunny.png"
            , "cow.png"
            , "cat.png"
            , "bear.png"
        };

        for (String animal_name: animal_list) {
            FileHandle fileHandle = Gdx.files.internal("data/animals/"+animal_name);
            Texture texture = new Texture(fileHandle);
            animal_textures.add(texture);
        }
    }
}