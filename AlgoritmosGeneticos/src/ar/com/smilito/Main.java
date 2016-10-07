package ar.com.smilito;

public class Main {

    public static void main(String[] args) {
        TuplaWrapper tw = new TuplaWrapper();
        tw.doReplacement();
        for(Tupla t : tw.getTuplaList())
            System.out.println(t);
    }
}
