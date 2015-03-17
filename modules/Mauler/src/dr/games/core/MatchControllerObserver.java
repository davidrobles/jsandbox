package dr.games.core;

public interface MatchControllerObserver<GAME extends Game<GAME>>
{
    void update(GAME game);
}
