import java.util.*;
/**
 * Miranda Patricia Pérez Camelo
 * 10/12/2023
 */

public class Main {
    public static void main(String[] args) {
        ABB arbol = new ABB();

        // 9,2,1,16,6,11,8,4
        arbol.insertarValor(9);
        arbol.insertarValor(2);
        arbol.insertarValor(1);
        arbol.insertarValor(16);
        arbol.insertarValor(6);
        arbol.insertarValor(11);
        arbol.insertarValor(8);
        arbol.insertarValor(4);

        arbol.arbolHorizontal(0, arbol.getRaiz());

        System.out.println("Recorrido en orden:");
        arbol.inOrden(arbol.getRaiz());
        System.out.println("\nRecorrido en preorden:");
        arbol.preOrden(arbol.getRaiz());
        System.out.println("\nRecorrido en postorden:");
        arbol.postOrden(arbol.getRaiz());
        
        System.out.println("Buscar valor 11:");
        int valor = 11;
        if(arbol.busquedaNodo(valor, arbol.getRaiz())){
            
            System.out.println("\nEl valor " + valor + " ha sido encontrado.");
            
        }
        else{

            System.out.println("\nEl valor " + valor + " no ha sido encontrado.");
            
        }
        
        System.out.println("Eliminar valor 11");

        arbol.eliminarValor(11);
        
        arbol.arbolHorizontal(0, arbol.getRaiz());
        
    }
}
