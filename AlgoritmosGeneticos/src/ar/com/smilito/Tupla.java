package ar.com.smilito;

import java.util.Comparator;
import java.util.Random;

/**
 * Created by ex_k009 on 07/10/2016.
 */
public class Tupla implements Comparable<Tupla>{

    private static Float ERROR = 0.00000001f;

    private Float x;
    private Float fx;
    private Float p;
    private static Random rand = new Random();

    public Float getX() {
        return x;
    }

    public Float getFx() {
        return f(x);
    }

    public static Float f(Float x){
        return 3 + 5 * x - (x * x);
    }

    // returns float value between 0 and 4
    public static Float randomDomainValue(){
        return rand.nextFloat() * 4;
    }

    public Float getP() {
        return p;
    }

    public void setX(Float x) {
        this.x = x;
    }

    // swap decimal values
    public static void swapDecimal(Tupla a, Tupla b){
        Float temp = a.getX().floatValue() - a.getX().intValue();
        a.setX(a.getX().intValue() + b.getX().floatValue() - b.getX().intValue());
        b.setX(b.getX().intValue() + temp);
    }

    public void refreshValue(Float efx){
        if(efx - 0 > ERROR){
            this.fx = f(x);
            this.p = fx / efx;
        }
    }

    @Override
    public int compareTo(Tupla o) {
        if( (this.p - o.getP()) < 0){
            return -1;
        } else {
            return 1;
        }
    }

    public Tupla(Float x){
        this.x = x;
        this.fx = f(x);
    }

    public Tupla(Float x, Float efx){
        this.x = x;
        this.fx = f(x);
        this.p = this.fx / efx;
    }

    public Tupla(){ }

    @Override
    public String toString() {
        return "Tupla{" +
                "x=" + x +
                ", fx=" + fx +
                ", p=" + p +
                '}';
    }

}
