package command;

import game.Game;

/**
 * The MoveArmyAction
 *
 * Moves an army to the destination provinces
 *
 * @author OliveGarch
 */
public class MoveArmyAction implements Action{

    private Game game;

    public MoveArmyAction(Game game) {
        this.game = game;
    }

    @Override
    public String performAction(String[] params) {
        // parse params for:
        //  army name
        //  destination province
        return null;
    }
}
