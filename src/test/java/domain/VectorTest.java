package domain;

import Domain.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void VectorTest() {

        int[] a = new int[50];
        Vector vector = new Vector(50);

        //vector.fill();
        for(int i = 0 ; i < 20 ; i++){
            vector.add(util.Utility.random(50));
        }

        System.out.println("Vector content not sorted:" + util.Utility.show(vector.getData()));

        vector.sort(); //Ordeno el vector

        System.out.println("Vector content sorted:" + util.Utility.show(vector.getData()));

        System.out.println("Vector size: " + vector.size());
        System.out.println(
                vector.isEmpty() ? "Vector is empty " : "Vector is not empy"
        );
    }
}