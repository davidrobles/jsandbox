package dr.games.players.mcts.enh;

import dr.games.core.Game;
import dr.games.players.EvalFunc;
import dr.games.players.mcts.tree.UCB1;

/**
 * An Upper Confidence Bounds for Trees algorithm that replaces
 * the default policy with an evaluation function.
 */
public class UCTNoRollout<GAME extends Game<GAME>> extends MCTSNoRollout<GAME>
{
    public UCTNoRollout(double c, EvalFunc<GAME> evalFunc)
    {
        super(new UCB1<GAME>(c), evalFunc);
    }

    public UCTNoRollout(double c, EvalFunc<GAME> evalFunc, int nSims)
    {
        super(new UCB1<GAME>(c), evalFunc, nSims);
    }
}
