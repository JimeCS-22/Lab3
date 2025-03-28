package domain;

import domain.Vector;
import org.junit.jupiter.api.Test;

class VectorTest {

    @Test
    void VectorTest() {

        int[] a = new int[50];
        Vector vector = new Vector(50);

        //vector.fill();
        for(int i = 0 ; i < 30 ; i++){
            vector.add(util.Utility.random(50));
        }

        System.out.println("Vector content not sorted:" + util.Utility.show(vector.getData()));

        vector.sort(); //Ordeno el vector

        System.out.println("Vector content sorted:" + util.Utility.show(vector.getData()));

        System.out.println("Vector size: " + vector.size());
        System.out.println(
                vector.isEmpty() ? "Vector is empty " : "Vector is not empy"
        );

        vector.add(10,2);
        vector.add(5,3);
        vector.add(0,4);

        System.out.println("Vector add: " + util.Utility.show(vector.getData()));

        System.out.println("Vector contains: " + vector.contains(3));
        System.out.println("Vector contains: " + vector.contains(51));

        vector.remove(10);
        System.out.println("Vector remove position 10: " + util.Utility.show(vector.getData()));

        vector.add(10,81);
        System.out.println("Vector add position 10: " + util.Utility.show(vector.getData()));

        vector.remove(5);
        System.out.println("Vector remove position 5: " + util.Utility.show(vector.getData()));


        vector.remove(0);
        vector.add(0,70);
        vector.add(5,40);
        System.out.println("Vector add position 5, remove pos 0 and add 70 in the pos: " + util.Utility.show(vector.getData()));

        vector.clear();
        System.out.println("Vector clear: " + util.Utility.show(vector.getData()));

    }
}