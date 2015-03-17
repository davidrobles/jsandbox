package dr.games.othello;

import dr.games.core.Game;
import dr.games.players.EvalFunc;

/**
 * Linear Evaluation function.
 * @param <GAME> the type of the game to be scored
 */
public interface LinearEF<GAME extends Game<GAME>> extends EvalFunc<GAME>
{
    /**
     * Updates the weights of the linear function with the temporal
     * difference error. This method is called on every time step
     * of an episode.
     * @param game the game
     * @param tdError temporal difference error
     */
    void updateWeights(GAME game, double tdError);
}
