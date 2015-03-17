package dr.games.players;

import dr.games.core.Game;

public interface Player<GAME extends Game<GAME>>
{
    boolean isDeterministic();
    int move(GAME game);
    int move(GAME game, int timeout);
}
