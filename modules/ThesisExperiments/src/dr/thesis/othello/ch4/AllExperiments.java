package dr.thesis.othello.ch4;

import dr.games.core.RoundRobin;
import dr.games.players.Player;
import dr.games.othello.Othello;
import dr.games.othello.ef.wpc.WPC;
import dr.games.othello.ef.wpc.WPCUtil;
import dr.games.players.GreedyPlayer;
import dr.games.players.mc.MonteCarlo;
import dr.games.players.mcts.UCT;
import dr.games.players.mcts.enh.UCTPrior;

import java.util.ArrayList;
import java.util.List;

public class AllExperiments
{
    static void allExperiments()
    {
        int nGames = 20;
        int timeout = 100;
        double c = 0.5;
        int nInit = 100;

        WPC wpc = new WPC(WPCUtil.load("dr-sym-6462"));
        List<Player<Othello>> players = new ArrayList<Player<Othello>>();
        List<String> playerNames = new ArrayList<String>();

        // Monte Carlo
        players.add(new MonteCarlo<Othello>());
        playerNames.add("MC");

        // UCT
        players.add(new UCT<Othello>(c));
        playerNames.add("UCT");

        // UCT + Non Random Default Policy
        players.add(new UCT<Othello>(new GreedyPlayer<Othello>(wpc), c));
        playerNames.add("UCT+NR");

        // UCT + Prior Knowledge
        players.add(new UCTPrior<Othello>(c, wpc, nInit));
        playerNames.add("UCT+PK");

        // UCT + Non Random Default Policy + Prior Knowledge
        GreedyPlayer<Othello> greedy = new GreedyPlayer<Othello>(wpc);
        players.add(new UCTPrior<Othello>(greedy, c, wpc, nInit));
        playerNames.add("UCT+NR+PK");

        RoundRobin<Othello> roundRobin = new RoundRobin<Othello>(new Othello(), nGames, players, playerNames, timeout);
        roundRobin.run();
        System.out.println(roundRobin.toLatexTable());
    }

    public static void main(String[] args)
    {
        allExperiments();
    }
}
