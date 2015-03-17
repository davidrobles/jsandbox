package dr.games.players;

import dr.games.core.Game;

/**
 * An evaluation function that scores game positions.
 */
public interface EvalFunc<GAME extends Game<GAME>> {

    /** Scores the given game state from the point of view of the given player. */
    double eval(GAME game, int player);
}
