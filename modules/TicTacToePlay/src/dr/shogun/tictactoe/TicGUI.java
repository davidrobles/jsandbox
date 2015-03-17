//package dr.shogun.tictactoe;
//
//import dr.games.core.MatchController;
//import dr.games.core.players.Player;
//import dr.games.core.players.RandPlayer;
//import dr.games.gui.BoardApp;
//import dr.games.gui.MatchControllerButtonsView;
//import dr.games.gui.MatchControllerSliderView;
//import dr.games.gui.MatchControllerTableView;
//import dr.games.tictactoe.TicTacToe;
//import dr.games.tictactoe.TicTacToeTableModel;
//import dr.games.tictactoe.TicTacToeView;
//
//import javax.swing.table.TableModel;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class TicGUI
//{
//    private static final Random rng = new Random();
//
//    public static void runTest()
//    {
//        TicTacToe tic = new TicTacToe();
//        List<Player<TicTacToe>> players = new ArrayList<Player<TicTacToe>>()
//        {{
//            add(new RandPlayer<TicTacToe>(rng));
//            add(new RandPlayer<TicTacToe>(rng));
//        }};
//
//        TicTacToeView panel = new TicTacToeView(tic);
//        MatchController<TicTacToe> mc = new MatchController<TicTacToe>(tic, players, 50);
//        MatchControllerButtonsView<TicTacToe> buttonsView = new MatchControllerButtonsView<TicTacToe>(mc);
//        MatchControllerSliderView<TicTacToe> sliderView = new MatchControllerSliderView<TicTacToe>(mc);
//        TableModel model = new TicTacToeTableModel(mc);
//        MatchControllerTableView<TicTacToe> mcTableView = new MatchControllerTableView<TicTacToe>(model, mc);
//        mc.registerObserver(mcTableView);
//        mc.registerObserver(buttonsView);
//        mc.registerObserver(sliderView);
//        mc.registerObserver(panel);
//        new BoardApp<TicTacToe>(panel, mc, buttonsView, sliderView, mcTableView);
//    }
//
//    public static void main(String[] args)
//    {
//        runTest();
//    }
//}
