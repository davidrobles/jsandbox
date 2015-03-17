package dr.games.players.mcts;

import dr.games.core.Game;
import dr.games.players.Player;
import dr.games.players.RandPlayer;
import dr.games.players.mcts.tree.UCB1;

/**
 * Upper Confidence Bounds for Trees. It uses the UCB1 tree policy
 * and the uniformly random default policy.
 */
public class UCT<GAME extends Game<GAME>> extends MCTS<GAME>
{
    public UCT(double c)
    {
        super(new UCB1<GAME>(c), new RandPlayer<GAME>());
    }

    public UCT(double c, int nSims)
    {
        super(new UCB1<GAME>(c), new RandPlayer<GAME>(), nSims);
        this.nSims = nSims;
    }

    public UCT(Player<GAME> defPolicy, double c)
    {
        super(new UCB1<GAME>(c), defPolicy);
    }

    public UCT(Player<GAME> defPolicy, double c, int nSims)
    {
        super(new UCB1<GAME>(c), defPolicy, nSims);
        this.nSims = nSims;
    }
}
