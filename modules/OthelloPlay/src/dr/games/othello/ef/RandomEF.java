package dr.games.othello.ef;

import dr.games.core.Game;
import dr.games.players.EvalFunc;

import java.util.Random;

public class RandomEF<GAME extends Game<GAME>> implements EvalFunc<GAME>
{
    private Random rng = new Random();

    @Override
    public double eval(GAME game, int player)
    {
        return rng.nextDouble() * 2 - 1;
    }
}
