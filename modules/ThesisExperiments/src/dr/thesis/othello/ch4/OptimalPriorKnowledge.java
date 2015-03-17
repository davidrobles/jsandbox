package dr.thesis.othello.ch4;

import dr.games.core.RoundRobin;
import dr.games.players.Player;
import dr.games.othello.Othello;
import dr.games.othello.ef.wpc.WPC;
import dr.games.othello.ef.wpc.WPCUtil;
import dr.games.players.mcts.enh.UCTPrior;

import java.util.ArrayList;
import java.util.List;

public class OptimalPriorKnowledge
{
    static void sim()
    {
        double c = 0.5;
        int nGames = 100;
        WPC wpc = new WPC(WPCUtil.load("dr-sym-6462"));

        // prior knowledge
        int priorInterval = 50;
        int[] priorRange = { 50, 250 };

        // number of simulations
        int nSimsInterval = 50;
        int[] nSimsRange = { 200 };

        Othello othello = new Othello();
        List<Player<Othello>> players = new ArrayList<Player<Othello>>();
        List<String> playersNames = new ArrayList<String>();

        for (int nSims = nSimsRange[0]; nSims <= nSimsRange[nSimsRange.length - 1]; nSims += nSimsInterval)
        {
            players.clear();
            playersNames.clear();

            for (int prior = priorRange[0]; prior <= priorRange[1]; prior += priorInterval)
            {
                players.add(new UCTPrior<Othello>(c, wpc, prior, nSims));
                playersNames.add("Prior=" + prior);
            }

            System.out.println("==================");
            System.out.println(" Timeout: " + nSims);
            System.out.println("==================");

            RoundRobin<Othello> roundRobin = new RoundRobin<Othello>(othello, nGames, players, playersNames, nSims);
            roundRobin.run();
        }
    }

    public static void main(String[] args)
    {
        sim();
    }
}
