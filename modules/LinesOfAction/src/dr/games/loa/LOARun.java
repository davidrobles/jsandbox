package dr.games.loa;

import dr.games.core.MatchController;
import dr.games.players.Player;
import dr.games.players.RandPlayer;
import dr.games.gui.BoardApp;
import dr.games.gui.MatchControllerButtonsView;
import dr.games.gui.MatchControllerSliderView;
import dr.games.gui.MatchControllerTableView;
import dr.util.DRUtil;

import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LOARun
{
    private static final Random RND = new Random();

    private static void runGUI()
    {
        LOA loa = new LOA();
        List<Player<LOA>> players = new ArrayList<Player<LOA>>()
        {{
                add(new RandPlayer<LOA>(RND));
                add(new RandPlayer<LOA>(RND));
            }};

        LOAView panel = new LOAView(loa);
        MatchController<LOA> mc = new MatchController<LOA>(loa, players, 50);
        MatchControllerButtonsView<LOA> buttonsView = new MatchControllerButtonsView<LOA>(mc);
        MatchControllerSliderView<LOA> sliderView = new MatchControllerSliderView<LOA>(mc);
        TableModel model = new LOATableModel(mc);
        MatchControllerTableView<LOA> mcTableView = new MatchControllerTableView<LOA>(model, mc);
        mc.registerObserver(mcTableView);
        mc.registerObserver(buttonsView);
        mc.registerObserver(sliderView);
        mc.registerObserver(panel);
        BoardApp<LOA> boardApp = new BoardApp<LOA>(panel, mc, buttonsView, sliderView, mcTableView);
        DRUtil.centerJFrame(boardApp);
    }

    public static void main(String[] args)
    {
        runGUI();
    }
}
