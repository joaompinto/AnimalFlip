package org.osgameseed.games.animalflip;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import org.osgameseed.games.animalflip.actors.GridBoard;

public class InputHandler extends InputListener {

    GridBoard board;

    public InputHandler(GridBoard board) {
        this.board = board;
    }

    public boolean touchDown(InputEvent event, float x, float y,
                             int pointer, int button) {
        Actor hit_card = board.hit(x, y, true);
        if(hit_card != null) {
            System.out.println("down "+hit_card.getName());
            hit_card.setTouchable(Touchable.disabled);
            board.recreate.add(hit_card);
            hit_card.addAction(
                    Actions.sequence(
                            Actions.fadeOut(0.5f),
                            board.new regenerate()
                    )
            );
        }
        return true;
    }

}

