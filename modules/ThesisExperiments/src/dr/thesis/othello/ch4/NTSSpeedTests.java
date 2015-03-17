package dr.thesis.othello.ch4;

import dr.games.players.Player;
import dr.games.core.util.SpeedTest;
import dr.games.othello.Othello;
import dr.games.players.EpsilonGreedy;
import dr.games.players.EvalFunc;

import java.util.HashMap;
import java.util.Map;

import static dr.thesis.othello.ch4.OthelloVF.*;

public class NTSSpeedTests
{
    static void RunAll()
    {
        Othello othello = new Othello();
        int timeoutInSecs = 10;
        double epsilon = 0.1;

        Map<String, EvalFunc<Othello>> players = new HashMap<String, EvalFunc<Othello>>();
        players.put("DR-WPC", WPC_SYM);
        players.put("FIRST-NTS", NTS_RND);
        players.put("RS-NTS", NTS_RS);
        players.put("LOG-NTS", NTS_LOG);
        players.put("EVO-NTS", NTS_EVO);

        for (Map.Entry<String, EvalFunc<Othello>> entry : players.entrySet())
        {
            Player<Othello> player = new EpsilonGreedy<Othello>(entry.getValue(), epsilon);
            double ntsGames = SpeedTest.playerSpeed(othello, player, timeoutInSecs);
            System.out.println(entry.getValue());
            System.out.format("%s %.1f games per second.\n", entry.getKey(), ntsGames);
            System.out.println("-------------------");
        }
    }

    public static void main(String[] args)
    {
        RunAll();
    }
}
