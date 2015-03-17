package dr.thesis.othello.ch4;

import dr.games.core.RoundRobin;
import dr.games.core.Series;
import dr.games.players.Player;
import dr.games.core.util.SpeedTest;
import dr.games.othello.Othello;
import dr.games.othello.ef.ntuples.NTUtil;
import dr.games.othello.ef.ntuples.NTupleSystem;
import dr.games.othello.ef.wpc.WPC;
import dr.games.othello.ef.wpc.WPCUtil;
import dr.games.players.EpsilonGreedy;
import dr.games.players.mcts.UCT;
import dr.games.players.minimax.AlphaBeta;
import dr.util.DRMarkdown;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static dr.thesis.othello.ch4.OthelloVF.*;

public class NTSComparisons
{
    static NTupleSystem nts = NTUtil.load("best-1");
    static NTupleSystem gen = NTUtil.load("buenero-56");
    static NTupleSystem logistello = NTUtil.load("logistello11-130000-0.822");
    static WPC wpc = new WPC(WPCUtil.load("dr-sym-6462"));

    static void VsRandomAt1PlySearch()
    {
        double epsilon = 0.0;
        int nGames = 1000;
        Othello othello = new Othello();

        List<Player<Othello>> players = new ArrayList<Player<Othello>>();
        players.add(new EpsilonGreedy<Othello>(logistello, epsilon));
//        players.add(new EpsilonGreedy<Othello>(wpc, epsilon));
        players.add(new UCT<Othello>(0.5, 500));
//        players.add(new RandPlayer<Othello>());

        Series<Othello> series = new Series<Othello>(othello, nGames, players);
        series.setVerbose(true);
        series.run();
    }

    static void At1PlySearch()
    {
        double epsilon = 0.1;
        int nGames = 10000;
        Othello othello = new Othello();

        List<Player<Othello>> players = new ArrayList<Player<Othello>>();
        players.add(new EpsilonGreedy<Othello>(logistello, epsilon));
        players.add(new EpsilonGreedy<Othello>(gen, epsilon));

        Series<Othello> series = new Series<Othello>(othello, nGames, players);
        series.setVerbose(true);
        series.run();
    }

    static void AtAlphaBeta()
    {
        int timeout = 50;
        int nGames = 50;
        Othello othello = new Othello();

        List<Player<Othello>> players = new ArrayList<Player<Othello>>();
        players.add(new AlphaBeta<Othello>(nts));
        players.add(new AlphaBeta<Othello>(wpc));

        Series<Othello> series = new Series<Othello>(othello, nGames, players, timeout);
        series.setVerbose(true);
        series.run();
    }

    static void RoundRobinAll()
    {
        int nGames = 5;
        int timeout = 250;

        List<Player<Othello>> players = new ArrayList<Player<Othello>>();
        List<String> playersNames = new ArrayList<String>();

        playersNames.add("DR-WPC");
//        players.add(new EpsilonGreedy<Othello>(WPC_SYM, 0.1));
        players.add(new AlphaBeta<Othello>(WPC_SYM));

        playersNames.add("LOG-NTS");
//        players.add(new EpsilonGreedy<Othello>(NTS_LOG, 0.1));
        players.add(new AlphaBeta<Othello>(NTS_LOG));

        playersNames.add("FIRST-NTS");
//        players.add(new EpsilonGreedy<Othello>(NTS_RND, 0.1));
        players.add(new AlphaBeta<Othello>(NTS_RND));

        playersNames.add("RS-NTS");
//        players.add(new EpsilonGreedy<Othello>(NTS_RS, 0.1));
        players.add(new AlphaBeta<Othello>(NTS_RS));

        playersNames.add("EVO-NTS");
//        players.add(new EpsilonGreedy<Othello>(NTS_EVO, 0.1));
        players.add(new AlphaBeta<Othello>(NTS_EVO));

        RoundRobin<Othello> roundRobin = new RoundRobin<Othello>(new Othello(), nGames, players, playersNames, timeout);
        roundRobin.run();
        System.out.println(roundRobin.toLatexTable());
    }

    static void NTSInfo()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Best 1", "best-1");
        map.put("Best 2", "best-2");
        map.put("Logistello", "logistello11-130000-0.822");

        for (Map.Entry<String, String> entry : map.entrySet())
        {
            DRMarkdown.printH1(entry.getKey());
            NTupleSystem logistello = NTUtil.load(entry.getValue());
            System.out.print(logistello.getInfo());
            double gamesPerSec = SpeedTest.playerSpeed(new Othello(), new EpsilonGreedy<Othello>(logistello, 0.1), 10);
            System.out.println("Games per second: " + gamesPerSec + "\n");
        }
    }

    public static void main(String[] args)
    {
        RoundRobinAll();
    }
}
