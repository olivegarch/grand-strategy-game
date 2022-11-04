package command;

import game.Game;

/**
 * The GetArmyStatusAction class
 *
 * Gets the status of an army
 *
 * @author OliveGarch
 */
public class GetArmyStatusAction implements Action{

    private Game game;

    public GetArmyStatusAction(Game game) {
        this.game = game;
    }

    @Override
    public String performAction(String[] params) {
        return null;
    }
}
