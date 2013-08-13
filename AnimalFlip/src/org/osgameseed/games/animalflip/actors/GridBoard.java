package org.osgameseed.games.animalflip.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;

import org.osgameseed.games.animalflip.Assets;

import java.util.Random;

public class GridBoard extends Group {

    public Array<Actor> recreate; // list of images that need to be recreated

    public GridBoard() {

        Random rand = new Random();
        recreate = new Array<Actor>();

        for(int i=0; i < 3*5; i++) {
            int rand_card_i = rand.nextInt(Assets.animal_textures.size);
            //System.out.println("Added "+rand_card_i+" "+card.getWidth());
            Image card = new Image(Assets.animal_textures.get(rand_card_i));
            float left_margin = 20;
            float top_margin = 200;
            float x_pos = left_margin+(i % 5)*155;
            float y_pos = (i / 5)*150;
            card.setPosition(x_pos, y_pos);
            card.setName(Integer.toString(i));
            addActor(card);
        }
    }

    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    public class regenerate extends Action {

        @Override
        public boolean act(float delta) {
            System.out.println("regenerating");
            Actor to_delete = recreate.removeIndex(0);
            float x_pos = to_delete.getX();
            float y_pos = to_delete.getY();
            String old_name = to_delete.getName();
            to_delete.remove();
            Random rand = new Random();
            int rand_card_i = rand.nextInt(Assets.animal_textures.size);
            Image card = new Image(Assets.animal_textures.get(rand_card_i));
            card.setPosition(x_pos, y_pos);
            card.setName(old_name);
            addActor(card);
            return true;
        }

    }
}

