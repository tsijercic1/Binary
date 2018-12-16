package ba.unsa.etf.dm.shannon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Grupa implements  Comparable{
    private ArrayList<KodnaRijec> grupa = new ArrayList<KodnaRijec>();
    private Double prob;
    private String kod="";
    private int half;

    public String getKod() {
        return kod;
    }

    public void code(String a){
        kod+=a;
    }
    public ArrayList<KodnaRijec> getGrupa() {
        return grupa;
    }

    public void setGrupa(ArrayList<KodnaRijec> grupa) {
        this.grupa = grupa;
    }

    public Double getProb() {
        prob = 0.0;
        for (int i=0;i<grupa.size();i++){
            prob+=grupa.get(i).getProb();
        }
        return prob;
    }

    public void add(KodnaRijec k){
        grupa.add(k);
        grupa.sort(new Comparator<KodnaRijec>() {
            @Override
            public int compare(KodnaRijec o1, KodnaRijec o2) {
                return o2.compareTo(o1);
            }
        });
    }

    public Grupa first(){

        Double p1=0.0, p2=0.0 ;
        int index=0;
        for(int i=0;i<grupa.size()-1;i++){
            p2+=grupa.get(i).getProb();
            if(p2+grupa.get(i+1).getProb()>this.getProb()*0.5){
                if(Math.abs(p2+grupa.get(i+1).getProb() - this.getProb()*0.5) > Math.abs(p2-this.getProb()*0.5)){
                    half=i;
                }else{
                    half=i+1;
                }
                break;
            }
        }
        ArrayList<KodnaRijec> f = new ArrayList<>();
        for(int i=0;i<=half;i++){
            f.add(grupa.get(i));
        }
        Grupa x = new Grupa();
        x.setGrupa(f);
        x.code(kod);
        return x;
    }

    public Grupa second(){

        Double p2=0.0;
        int index=0;
        ArrayList<KodnaRijec> f = new ArrayList<>();
        for(int i=half+1;i<grupa.size();i++){
            f.add(grupa.get(i));
        }
        Grupa x = new Grupa();
        x.setGrupa(f);
        x.code(kod);
        return x;
    }

    @Override
    public int compareTo(Object o) {
        return this.getProb().compareTo(((Grupa)o).getProb());
    }

    @Override
    public String toString() {
        return grupa+"   /    "+kod;
    }
}
