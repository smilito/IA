package ar.com.smilito;

import java.util.*;

/**
 * Created by ex_k009 on 07/10/2016.
 */
public class TuplaWrapper {

    public static int LIST_SIZE = 10;
    public static int ITERATIONS = (int) Math.pow(100, 4);

    private List<Tupla> tuplaList = new ArrayList<Tupla>();
    private Float efx = new Float(0);

    public List<Tupla> getTuplaList() {
        return tuplaList;
    }

    private void init(){
        for(int i=0 ; i < LIST_SIZE ; i++){
            Tupla t = new Tupla(Tupla.randomDomainValue());
            efx += t.getFx();
            t.refreshValue(efx);
            tuplaList.add(t);
        }
        sortList();
    }

    public TuplaWrapper(){
        init();
    }

    private void sortList(){
        Collections.sort(tuplaList);
    }

    public void doReplacement(){
        for(int i=0 ; i < ITERATIONS ; i++){
            Float [] randomValues = {new Random().nextFloat(), new Random().nextFloat()};
            int index1 = getIndexOfObjectInList(randomValues[0]);
            int index2 = getIndexOfObjectInList(randomValues[1]);
            Tupla object1 = tuplaList.get(index1);
            Tupla object2 = tuplaList.get(index2);
            Tupla.swapDecimal(object1,object2);
            tuplaList.set(index1,object1);
            tuplaList.set(index2,object2);
            refreshValues();
        }
    }

    private void refreshValues(){
        this.efx = 0f;
        for(Tupla t : tuplaList){
            efx += t.getFx();
            t.refreshValue(efx);
        }
        sortList();
    }

    private int getIndexOfObjectInList(Float value){
        int index = 0;
        for(Tupla t : tuplaList){
            if(value > t.getP()){
                index++;
            } else {
                break;
            }
        }
        return index;
    }

}
