package Utiles;

import java.util.List;

public class Utils {

    //USANDO GENERICOS NOS PERMITE REUUTILIZARLO EN TODAS LAS ENTIDADES

    public static <A> A[]  listToArray(List<A> list){
        //crear un array del tamaño de la lista
        A[] array = (A[]) new Object[list.size()];

        int i = 0;
        for( A iterador : list){
            array[i++] = iterador;
        }
        return array;
    }
}