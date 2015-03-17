//package dr.shogun.tictactoe;
//
//import dr.games.core.Game;
//import dr.games.core.players.RandPlayer;
//import dr.games.core.util.GamesUtil;
//import dr.games.othello.Othello;
//import dr.games.players.UtilFunc;
//import dr.games.players.mcts.GraphvizMCTSObserver;
//import dr.games.players.mcts.MCTS;
//import dr.games.players.mcts.tree.UCB1;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Random;
//
//public class GraphvizRight {
//
//    public static void main(String[] args) throws IOException {
//        hello();
//    }
//
//    private static void hello() throws IOException {
//        Othello othello = new Othello();
//        boolean advanceSuccesful = GamesUtil.advanceGame(othello, 30);
//        System.out.println(othello);
////        double[] c = { 0.2, 5.0, 10.0 };
//        double[] c = { 100 };
//        int nSims = 40000;
//
//        for (int i = 0; i < c.length; i++) {
//            Othello game = othello.copy();
//            MCTS<Othello> mcts = new MCTS<Othello>(new UCB1<Othello>(c[i], new Random()), new RandPlayer<Othello>(), nSims);
//            String filename = "/Users/drobles/Dropbox/Temp/Graphviz/dr-" + c[i] + ".dot";
//            File file = new File(filename);
//            GraphvizMCTSObserver obs = new GraphvizMCTSObserver(file);
////            mcts.addMctsObserver(obs);
//            mcts.setUtilFunc(new UtilFunc<Othello>(1.0, 0.0, 0.5));
//            mcts.move(game);
//
////            Runtime rt = Runtime.getRuntime();
////            Process pr = rt.exec("twopi -Tpdf dot.dot -o dot.pdf");
//        }
//    }
//}
