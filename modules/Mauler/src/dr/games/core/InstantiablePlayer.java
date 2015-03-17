package dr.games.core;

public interface InstantiablePlayer<GAME extends Game<GAME>>
{
    GAME newInstance();
}
