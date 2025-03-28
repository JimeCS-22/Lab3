package domain;

import java.util.Random;

public class DivideConquer {


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
    public int binarySearchI(int[] nums, int value) {
        // el espacio de búsqueda es nums[low…high]
        int low = 0;
        int high = nums.length - 1;

        // bucle hasta que se agote el espacio de búsqueda
        while (low <= high) {
            // encuentra el valor medio en el espacio de búsqueda y
            // lo compara con el objetivo

            int mid = (low + high) / 2;

            // se encuentra el objetivo
            if (value == nums[mid]) {
                return mid;
            }

            // descartar todos los elementos en el espacio de búsqueda correcto,
            // incluyendo el elemento del medio
            else if (value < nums[mid]) {
                high = mid - 1;
            }

            // descartar todos los elementos en el espacio de búsqueda de la izquierda,
            // incluyendo el elemento del medio
            else {
                low = mid + 1;
            }
        }

        // `value` no existe en la array
        return -1;
    }

    //MaxMin
    public int[] MinMax(int arr[]) {

        int t[] = new int[2];
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {

            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);

        }

        t[0] = min;
        t[1] = max;

        return t;

    }


//    // Método de búsqueda aleatoria
//    public int buscarAleatoriamente() {
//        Random random = new Random();
//        // Arreglo de ejemplo
//        int[] arreglo = {3, 1, 9, 4, 5, 7, 8, 10, 2};
//        // Valor que queremos buscar
//        int objetivo = 7;
//
//        // Número total de elementos en el arreglo
//        int n = arreglo.length;
//
//        // Continuamos buscando hasta encontrar el objetivo
//        while (true) {
//            // Generamos un índice aleatorio
//            int indiceAleatorio = random.nextInt(n);
//
//            // Verificamos si el valor en el índice aleatorio es el que buscamos
//            if (arreglo[indiceAleatorio] == objetivo) {
//                return indiceAleatorio; // Si encontramos el valor, devolvemos el índice
//            }
//        }
//    }

}

