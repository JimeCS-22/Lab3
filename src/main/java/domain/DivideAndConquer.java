package domain;

public class DivideAndConquer {


    //Recursivo
    public int binarySearchR(int sortedArray[], int value, int low, int high) {

        int mid = (low + high) / 2;

        if (low > high) {

            return -1;

        } else
            // se encuentra el objetivo
            if (value == sortedArray[mid]) {
                return mid;
            } else if (value < sortedArray[mid]) {
                return binarySearchR(sortedArray, value, low, mid - 1);
            } else {
                return binarySearchR(sortedArray, value, mid + 1, high);
            }

    }

    //Iterativo
    public int binarySearchI(int sortedArray[], int value) {
        // el espacio de búsqueda es nums[low…high]
        int low = 0;
        int high = sortedArray.length - 1;

        // bucle hasta que se agote el espacio de búsqueda
        while (low <= high) {
            // encuentra el valor medio en el espacio de búsqueda y
            // lo compara con el objetivo

            int mid = (low + high) / 2;

            // se encuentra el objetivo
            if (value == sortedArray[mid]) {
                return mid;
            }

            // descartar todos los elementos en el espacio de búsqueda correcto,
            // incluyendo el elemento del medio
            else if (value < sortedArray[mid]) {
                high = mid - 1;
            }

            // descartar todos los elementos en el espacio de búsqueda de la izquierda,
            // incluyendo el elemento del medio
            else {
                low = mid + 1;
            }
        }

        // value no existe en la array
        return -1;
    }

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
