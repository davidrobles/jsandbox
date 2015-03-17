package dr.games.planetwars;

import java.util.List;

public interface PWBot {

    List<PWOrder> getOrders(PWGameState gameState);
    
}
