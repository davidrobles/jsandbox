package dr.games.players.mcts;

import dr.games.core.Game;

public interface MCTSObserver<GAME extends Game<GAME>>
{
    void simulationFinished(MCTSNode<GAME> game);
}
