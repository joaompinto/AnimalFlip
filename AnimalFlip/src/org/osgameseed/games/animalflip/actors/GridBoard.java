package org.osgameseed.games.animalflip.actors;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;


import org.osgameseed.games.animalflip.Assets;

import java.util.Random;

public class GridBoard extends Group {

    BitmapFont font;                // For the touch count label
    Label.LabelStyle font_style;
    Random rand;

    int touched_counter; // count of cards that have been touched
    int last_card_face; // last card face index

    int placed_faces_count[]; // list of counts per card face
    Array<Actor> flipped_cards; // list of flipped cards
    Array<Actor> placed_numbers; // list of placed numbers;

    public GridBoard() {


        rand = new Random();

        font = new BitmapFont(Gdx.files.internal("data/fonts/numbers.fnt"),
                Gdx.files.internal("data/fonts/numbers.png"), false);
        font_style = new Label.LabelStyle(font, Color.WHITE);

        touched_counter = 0;
        last_card_face = -1;

        flipped_cards = new Array<Actor>();
        placed_numbers = new Array<Actor>();
        placed_faces_count = new int[Assets.animal_textures.size];

        int rows;
        if(Gdx.app.getType() == Application.ApplicationType.Desktop)
            rows = 4;
        else
            rows = 3;
        int columns = 5;

        // Fill the board with random cards
        for(int i=0; i < rows*columns; i++) {
            int rand_card_i = rand.nextInt(Assets.animal_textures.size);
            addCard(rand_card_i, i);
        }
    }

    private Actor addCard(int card_face, float x, float y) {

        // Create the card object
        Image card = new Image(Assets.animal_textures.get(card_face));
        card.setPosition(x, y);
        card.setName(Integer.toString(card_face));

        // Set to invisible and not touchable on start
        Color color = card.getColor();
        card.setColor(color.r, color.g, color.b, 0f);
        card.setTouchable(Touchable.disabled);

        addActor(card);

        placed_faces_count[card_face]++; // Increment the faces count for the new card

        //
        card.addAction(
                Actions.sequence(
                        Actions.fadeIn(0.5f),
                        new on_flip_in()
                )
        );

        return card;
    }

    private Actor addCard(int card_face, int board_pos) {

        // Create the card object
        Image card = new Image(Assets.animal_textures.get(card_face));
        float left_margin = 20;
        float x = left_margin+(board_pos % 5)*155;
        float y = (board_pos / 5)*150;
        return addCard(card_face, x, y);
    }

    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    public class InputHandler extends InputListener {


        public InputHandler() {
        }

        public boolean touchDown(InputEvent event, float x, float y,
                                 int pointer, int button) {
            Actor hit_card = hit(x, y, true);
            if(hit_card != null) {
                int hit_card_face = Integer.parseInt(hit_card.getName());

                if(last_card_face != -1 && hit_card_face != last_card_face) // Not with the same face
                    return true;

                last_card_face =   hit_card_face;
                flipped_cards.add(hit_card);

                Label countLabel = new Label(Integer.toString(flipped_cards.size), font_style);
                countLabel.setTouchable(Touchable.disabled);

                float pos_x = hit_card.getX() + hit_card.getWidth()/2-30;
                float pos_y = hit_card.getY() + hit_card.getHeight()/2-30;
                countLabel.setPosition(pos_x, pos_y);

                addActor(countLabel);
                placed_numbers.add(countLabel);

                hit_card.setTouchable(Touchable.disabled);
                hit_card.addAction(
                        Actions.sequence(
                                Actions.fadeOut(0.5f),
                                new on_flip_out()
                        )
                );
            }
            return true;
        }

    }

    public class on_flip_in extends Action {

        @Override
        public boolean act(float delta) {

            Actor flipped_card = getActor();
            flipped_card.setTouchable(Touchable.enabled);
            return true;
        }

    }

    public class on_flip_out extends Action {

        @Override
        public boolean act(float delta) {

            Actor flipped_card = getActor();

            int flipped_card_face = Integer.parseInt(flipped_card.getName());

            // Check if the last card was touched
            if(flipped_cards.size == placed_faces_count[flipped_card_face]) {
                for(Actor old_card: flipped_cards) {
                    // Remove the old card
                    float old_x = old_card.getX();
                    float old_y = old_card.getY();
                    int old_card_face = Integer.parseInt(old_card.getName());
                    old_card.remove();
                    placed_faces_count[old_card_face]--;
                    int rand_card_i = rand.nextInt(Assets.animal_textures.size);
                    addCard(rand_card_i, old_x, old_y);
                    last_card_face = -1;
                }
                flipped_cards.clear();
                for(Actor number: placed_numbers) {
                    number.remove();
                }
                placed_numbers.clear();
            }
            return true;
        }

    }
}

