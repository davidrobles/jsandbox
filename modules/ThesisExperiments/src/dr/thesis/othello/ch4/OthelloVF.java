package dr.thesis.othello.ch4;

import dr.games.othello.ef.ntuples.NTUtil;
import dr.games.othello.ef.ntuples.NTupleSystem;
import dr.games.othello.ef.wpc.WPC;
import dr.games.othello.ef.wpc.WPCUtil;

public class OthelloVF
{
    // Value functions
    public static WPC             WPC_SYM = new WPC(WPCUtil.load("dr-sym-6462"));
    public static NTupleSystem    NTS_RND = NTUtil.load("turing-5000-0.228");
    public static NTupleSystem     NTS_RS = NTUtil.load("best-1");
    public static NTupleSystem    NTS_LOG = NTUtil.load("logistello11-130000-0.822");
    public static NTupleSystem    NTS_EVO = NTUtil.load("buenero-56");
}
