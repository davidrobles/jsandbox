package dr.thesis.othello.ch4;

import dr.games.core.RoundRobin;
import dr.games.players.Player;
import dr.games.othello.Othello;
import dr.games.othello.ef.ntuples.NTUtil;
import dr.games.othello.ef.ntuples.NTupleSystem;
import dr.games.othello.ef.wpc.WPC;
import dr.games.othello.ef.wpc.WPCUtil;
import dr.games.players.EpsilonGreedy;
import dr.games.players.GreedyPlayer;
import dr.games.players.mcts.MCTS;
import dr.games.players.mcts.tree.UCB1;

import java.util.ArrayList;
import java.util.List;

public class NTSinMCTS
{
    /**
     * MCTS using Logistello (epsilon-greedy) default policy.
     * This is a round robin tournament using different values of epsilon.
     */
    public static void MCTSWithLogistelloDP()
    {
        Othello othello = new Othello();
//        NTupleSystem logistello = NTUtil.load("logistello11-130000-0.822");
        WPC wpc = new WPC(WPCUtil.load("dr-sym-6462"));

        double[] epsilonValues = { 0.0, 0.2, 0.4, 0.6, 0.8, 1.0 };
//        double[] epsilonValues = { 0.0, 0.01, 0.1, 0.2, 0.4 };
        double c = 0.5;
        int nGames = 100;
        int timeout = 50;
//        int nSims = 2500;

        List<Player<Othello>> players = new ArrayList<Player<Othello>>();
        List<String> playersNames = new ArrayList<String>();

        for (int i = 0; i < epsilonValues.length; i++)
        {
            EpsilonGreedy<Othello> eGreedyLogistello = new EpsilonGreedy<Othello>(wpc, epsilonValues[i]);
            MCTS<Othello> mcts = new MCTS<Othello>(new UCB1<Othello>(c), eGreedyLogistello);
            players.add(mcts);
            playersNames.add("e = " + epsilonValues[i]);
        }

        RoundRobin<Othello> rr = new RoundRobin<Othello>(othello, nGames, players, playersNames, timeout);
        rr.run();
        System.out.println(rr.toLatexTable());
    }

    public static void main(String[] args)
    {
        MCTSWithLogistelloDP();
    }
}
