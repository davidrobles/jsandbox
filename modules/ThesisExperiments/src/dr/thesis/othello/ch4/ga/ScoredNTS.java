package dr.thesis.othello.ch4.ga;

import dr.games.othello.ef.ntuples.NTupleSystem;

public class ScoredNTS implements Comparable<ScoredNTS>
{
    private NTupleSystem nts;
    private double fitness;

    public ScoredNTS(NTupleSystem nts)
    {
        this.nts = nts;
    }

    public ScoredNTS(NTupleSystem nts, double fitness)
    {
        this.nts = nts;
        this.fitness = fitness;
    }

    public NTupleSystem getNTupleSystem()
    {
        return nts;
    }

    public double getFitness()
    {
        return fitness;
    }

    public void setFitness(double fitness)
    {
        this.fitness = fitness;
    }

    @Override
    public int compareTo(ScoredNTS other)
    {
        if (this.fitness < other.fitness)
            return 1;
        else if (this.fitness > other.fitness)
            return -1;

        return 0;
    }
}