package dr.games.players.mcts.enh;

import dr.games.core.Game;
import dr.games.players.EvalFunc;
import dr.games.players.mcts.MCTS;
import dr.games.players.mcts.MCTSNode;
import dr.games.players.mcts.tree.TreePolicy;

public class MCTSNoRollout<GAME extends Game<GAME>> extends MCTS<GAME>
{
    private EvalFunc<GAME> evalFunc;

    public MCTSNoRollout(TreePolicy<GAME> treePolicy, EvalFunc<GAME> evalFunc)
    {
        super(treePolicy, null);
        this.evalFunc = evalFunc;
    }

    public MCTSNoRollout(TreePolicy<GAME> treePolicy, EvalFunc<GAME> evalFunc, int nSims)
    {
        super(treePolicy, null, nSims);
        this.evalFunc = evalFunc;
    }

    //////////////////
    // AbstractMCTS //
    //////////////////

    @Override
    protected double simDefault(MCTSNode<GAME> node, int player)
    {
        return evalFunc.eval(node.getGame(), player);
    }

    ////////////
    // Object //
    ////////////

    @Override
    public String toString()
    {
        if (nSims > 0)
            return String.format("<MCTSNoRollout treePolicy: %s, defaultPolicy: %s, evalFunc: %s, nSims: %d>",
                    treePolicy, defPolicy, evalFunc, nSims);
        else
            return String.format("<MCTSNoRollout treePolicy: %s, defaultPolicy: %s, evalFunc: %s>",
                    treePolicy, defPolicy, evalFunc);
    }
}
