package Domain;

public class Dynamic {

    public static long factorial(int n){

        //Dividir el problema
        //Caso base: es que el número sea 0 o 1 va a devolver 1
        if( n == 0 || n == 1){

            return 1;

        }

        //Resolucion del problema
        //Preguntarle al profe que se recomienda un int o un long
        long [] t = new long [n];

        //Uso de un for
        for( int i = 2; i<n ; i++){

            t[i] = t[i-1] * i ;

        }

        return t[n];

    }

    public static int Fibonnacci(int n){

        int[] t = new int [n+1];

        //Dividir el problema en el caso base
        //Aqui estan el caso de que n sea 0 y que n sea 1
        if(n==0 || n==1){

            return n;
        }

        //Resolucion del problema
        //Uso del for para llenar el arreglo y conseguir la solucion
        for(int i= 2; i<n; i++){
            t[i]= t[i-1] + t[i-2];
        }

        return t[n];

    }

}
