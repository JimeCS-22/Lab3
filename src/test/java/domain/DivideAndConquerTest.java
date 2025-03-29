package domain;

import domain.ArrayMinMax;
import domain.DivideAndConquer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class DivideAndConquerTest {

    @Test
    void binarySearch() {
        int[] a = new int[50];

        // Llenamos el array con valores aleatorios
        util.Utility.fill(a);

        // Mostrar el contenido del array no ordenado
        System.out.println("Array content before sorting:");
        System.out.println(Arrays.toString(a));

        // Ordenamos el array
        Arrays.sort(a);

        // Mostrar el contenido del array ordenado
        System.out.println("\nArray content after sorting:");
        System.out.println(Arrays.toString(a));

        // Realizamos las búsquedas aleatorias
        for (int i = 0; i < 20; i++) {
            int randomValue = util.Utility.random(50);
            System.out.println(" ");

            // Usamos el método java.util.Arrays.binarySearch
            int result = Arrays.binarySearch(a, randomValue);
            if (result >= 0) {
                System.out.println("JAVA.UTIL.ARRAYS CLASS BS... The element " + randomValue + " exists at position [" + result + "]");
            } else {
                System.out.println("JAVA.UTIL.ARRAYS CLASS BS... The element " + randomValue + " does not exist in java Arrays");
            }

            // Usamos el método java.util.Collections.binarySearch
            List<Integer> list = new ArrayList<>();
            for (int num : a) {
                list.add(num);
            }
            int collectionResult = Collections.binarySearch(list, randomValue);
            if (collectionResult >= 0) {
                System.out.println("JAVA.UTIL.COLLECTIONS BS... The element " + randomValue + " exists at position [" + collectionResult + "]");
            } else {
                System.out.println("JAVA.UTIL.COLLECTIONS BS... The element " + randomValue + " does not exist in java Collections");
            }

            // Usamos la búsqueda binaria iterativa
            int iterativeResult = DivideAndConquer.binarySearchI(a, randomValue);
            if (iterativeResult >= 0) {
                System.out.println("(Domain.DivideAndConquer) ITERATIVE BS... The element " + randomValue + " exists at position [" + iterativeResult + "]");
            } else {
                System.out.println("(Domain.DivideAndConquer) ITERATIVE BS... The element " + randomValue + " does not exist in array");
            }

            // Usamos la búsqueda binaria recursiva
            int recursiveResult = DivideAndConquer.binarySearchR(a, randomValue, 0, a.length - 1);
            if (recursiveResult >= 0) {
                System.out.println("(Domain.DivideAndConquer) RECURSIVE BS... The element " + randomValue + " exists at position [" + recursiveResult + "]");
            } else {
                System.out.println("(Domain.DivideAndConquer) RECURSIVE BS... The element " + randomValue + " does not exist in array");
            }
        }
    }




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