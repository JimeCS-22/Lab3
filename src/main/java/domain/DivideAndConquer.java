package domain;

public class DivideAndConquer {


    public static ArrayMinMax findMinMax(int[] a, int low, int high) {

//Base case 1, only one element
        if (low == high) {

            return new ArrayMinMax(a[low], a[high]);

        }//No hay else porque sería decir lo mismo que el return

        //Base case 2, solution with two elements
        if (high == low + 1) {
            new ArrayMinMax(Math.min(a[low], a[high]), Math.max(a[low], a[high]));
            new ArrayMinMax(util.Utility.min(a[low], a[high]), util.Utility.max(a[low], a[high]));

        }

        return null;//Se cambia a lo que corresponde
    }


}
