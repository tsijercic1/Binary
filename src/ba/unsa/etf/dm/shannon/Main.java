package ba.unsa.etf.dm.shannon;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Grupa moj = new Grupa();
        moj.add(new KodnaRijec("A",86.0/421));
        moj.add(new KodnaRijec("B",34.0/421));
        moj.add(new KodnaRijec("C",19.0/421));
        moj.add(new KodnaRijec("D",11.0/421));
        moj.add(new KodnaRijec("E",42.0/421));
        moj.add(new KodnaRijec("F",87.0/421));
        moj.add(new KodnaRijec("G",22.0/421));
        moj.add(new KodnaRijec("H",17.0/421));
        moj.add(new KodnaRijec("I",15.0/421));
        moj.add(new KodnaRijec("J",88.0/421));
        Shannon kod = new Shannon();
        kod.add(moj);
        int n=0;
        while(kod.iterate()){
            System.out.println(kod);
            System.out.println("Iteracija "+n);
            n++;
        }

        System.out.println(kod.toString());
        System.out.println("entropija = "+kod.entropija());
        System.out.println("nsrednje = "+kod.nsrednje());
        System.out.println("protok = "+kod.protok()+"/tau");

    }
}
