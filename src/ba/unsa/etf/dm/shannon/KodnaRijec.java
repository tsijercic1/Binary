package ba.unsa.etf.dm.shannon;

public class KodnaRijec implements Comparable{
    private String naziv;
    private Double prob;


    public KodnaRijec(String naziv, Double prob) {
        this.naziv = naziv;
        this.prob = prob;
    }

    public Double getProb() {
        return prob;
    }

    @Override
    public int compareTo(Object o) {
        return prob.compareTo(((KodnaRijec)o).getProb());
    }

    @Override
    public String toString() {
        return naziv + '/' +prob;
    }
}
