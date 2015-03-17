package dr.games.players.mcts.tree;

import dr.games.core.Game;
import dr.games.players.mcts.MCTSNode;

/**
 * A tree policy makes a move by looking at the information
 * in the MCTS node.
 */
public interface TreePolicy<GAME extends Game<GAME>>
{
    // TODO: do i really need the player parameter?
    int move(MCTSNode<GAME> node, int player);
}
