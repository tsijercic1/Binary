package ba.unsa.etf.dm.shannon;

import java.util.ArrayList;

public class Shannon {
    private ArrayList<Grupa> grupe = new ArrayList<>();

    public void add(Grupa x){
        grupe.add(x);
    }

    public boolean iterate(){
        int vel=0;
        for(int i=0;i<grupe.size();i++){
            vel+=grupe.get(i).getGrupa().size();
        }
        if(vel==grupe.size()){
            System.out.println("KRAJ KODIRANJA");
            return false;
        }
        ArrayList<Grupa> next = new ArrayList<>();
        for(int i=0;i<grupe.size();i++){
            if(grupe.get(i).getGrupa().size()>1){
                Grupa jedan = grupe.get(i).first();
                jedan.code("0");
                Grupa dva = grupe.get(i).second();
                dva.code("1");
                next.add(jedan);
                next.add(dva);
            }else{
                next.add(grupe.get(i));
            }
        }
        grupe = next;
        return true;
    }

    @Override
    public String toString() {
        String res="";
        for(int i=0;i<grupe.size();i++){
            res+=grupe.get(i)+"\n";
        }
        return res;
    }

    public double entropija(){
        double e=0;
        for(int i=0;i<grupe.size();i++){
            e+=grupe.get(i).getProb()*Math.log10(grupe.get(i).getProb())/Math.log10(2);
        }
        e=-e;
        return e;
    }
    public double nsrednje(){
        double res = 0;
        for(int i=0;i<grupe.size();i++){
            res+=grupe.get(i).getProb()*grupe.get(i).getKod().length();
        }
        return res;
    }
    public double protok(){
        return this.entropija()/this.nsrednje();
    }

}
