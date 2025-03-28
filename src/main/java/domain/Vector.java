package domain;

import java.util.Arrays;

public class Vector implements VectorInterface {

    private int n; //tamaño máximo del vector
    private int data[]; //array de elementos tipo enteros
    private int counter;//cantidad de elementos agregados

    //Constructor
    public Vector(int n) {

        this.n = n;
        this.data = new int[n];
        this.counter = 0;
    }

    public int[] getData() {

        return data;

    }

    @Override
    public int size() {

        return counter;
    }

    @Override
    public void clear() {

        this.data = new int[n];
        this.counter = 0;

    }

    @Override
    public boolean isEmpty() {

        return counter == 0;

    }

    @Override
    public boolean contains(Object element) {
        for (int i = 0; i < counter; i++) {
            if (data[i] == (int) element) {
                return true; // Elemento encontrado
            }
        }
        return false; // Elemento no encontrado

    }

    @Override
    public void add(Object element) {

        if (counter < this.data.length) {
            this.data[counter++] = (int) element;
        }

    }

    @Override
    public void add(int index, Object element) {

        if (index < data.length) {

            data[index] = (int) element;

            if (counter <= index)
                counter = index + 1;

        }


    }

    @Override
    public boolean remove(Object element) {
        for (int i = 0; i < counter; i++) {
            if (data[i] == (int) element) {
                // Elimina el elemento desplazando el resto de los elementos a la izquierda
                for (int j = i; j < counter - 1; j++) {
                    data[j] = data[j + 1];
                }
                data[--counter] = 0; // Ajustamos el tamaño y establecemos el último elemento como 0
                return true; // Elemento eliminado con éxito
            }
        }
        return false; // Elemento no encontrado
    }

    @Override
    public Object remove(int index) {
        if (index >= 0 && index < counter) {
            int removedElement = data[index];

            // Desplazar los elementos hacia la izquierda
            for (int i = index; i < counter - 1; i++) {
                data[i] = data[i + 1];
            }
            data[--counter] = 0; // Ajustar el tamaño y establecer el último elemento como 0
            return removedElement; // Retorna el elemento eliminado
        }
        return -1; // Índice fuera de rango

    }

    @Override
    public void sort() {

        bubbleSort(this.data, counter);

    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < counter; i++) {
            if (data[i] == (int) element) {

                return i; // Índice del elemento

            }
        }
        return -1; // No hay un índice del elemento
    }

    @Override
    public Object get(int index) {

        if (index >= 0 && index < counter) {
            return data[index];
        }

        return -1; // Índice fuera de rango
    }

    @Override
    public void fill() {
        util.Utility.fill(this.data);
        this.counter = this.n;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "n=" + n +
                ", data=" + Arrays.toString(data) +
                ", counter=" + counter +
                '}';
    }

    static void bubbleSort(int arr[], int n) {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }


}