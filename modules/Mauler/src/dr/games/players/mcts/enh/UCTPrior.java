package dr.games.players.mcts.enh;

import dr.games.core.Game;
import dr.games.players.Player;
import dr.games.players.RandPlayer;
import dr.games.players.EvalFunc;
import dr.games.players.mcts.tree.UCB1;

/**
 * An Upper Confidence Bounds for Trees algorithm with prior knowledge
 * initialisation in the tree policy.
 */
public class UCTPrior<GAME extends Game<GAME>> extends MCTSPrior<GAME>
{
    public UCTPrior(double c, EvalFunc<GAME> priorEF, int initQVisits)
    {
        super(new UCB1<GAME>(c), new RandPlayer<GAME>(), priorEF, initQVisits);
    }

    public UCTPrior(double c, EvalFunc<GAME> priorEF, int initQVisits, int nSims)
    {
        super(new UCB1<GAME>(c), new RandPlayer<GAME>(), priorEF, initQVisits, nSims);
    }

    public UCTPrior(Player<GAME> defPolicy, double c, EvalFunc<GAME> priorEF, int initQVisits)
    {
        super(new UCB1<GAME>(c), defPolicy, priorEF, initQVisits);
    }

    public UCTPrior(Player<GAME> defPolicy, double c, EvalFunc<GAME> priorEF, int initQVisits, int nSims)
    {
        super(new UCB1<GAME>(c), defPolicy, priorEF, initQVisits, nSims);
    }
}
