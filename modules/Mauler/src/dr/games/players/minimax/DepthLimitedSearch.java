package dr.games.players.minimax;

import dr.games.core.Game;
import dr.games.players.Player;

/**
 * Search algorithms that implement this interface search up to a given max depth.
 */
public interface DepthLimitedSearch<GAME extends Game<GAME>> extends Player<GAME>
{
    int move(int maxDepth, GAME game);
}
