package domain;

import domain.ArrayMinMax;
import domain.DivideAndConquer;
import org.junit.jupiter.api.Test;

class DivideAndConquerTest {

    @Test
    void findMinMax(){

        int[] a = new int[100];

        util.Utility.fill(a);

        System.out.println("Array content:\n" + util.Utility.show(a));
        ArrayMinMax minMax = DivideAndConquer.findMinMax(a, 0, a.length-1);
        System.out.println("Array min item: " +minMax.getMin()
                +"\nArray max item: "+minMax.getMax());

    }

}