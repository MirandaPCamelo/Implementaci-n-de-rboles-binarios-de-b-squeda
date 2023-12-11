import java.util.*;
/**
 * Miranda Patricia Pérez Camelo
 * 10/12/2023
 */

public class Main {
    public static void main(String[] args) {
        ABB arbol = new ABB();

        //25, 8, 29, 38, 27
	arbol.insertarValor(25);
	arbol.insertarValor(8);
	arbol.insertarValor(29);
	arbol.insertarValor(38);
	arbol.insertarValor(27);

        arbol.arbolHorizontal(0, arbol.getRaiz());

        System.out.println("Recorrido en orden:");
        arbol.inOrden(arbol.getRaiz());
        System.out.println("\nRecorrido en preorden:");
        arbol.preOrden(arbol.getRaiz());
        System.out.println("\nRecorrido en postorden:");
        arbol.postOrden(arbol.getRaiz());
        
        System.out.println("Buscar valor 38:");
        int valor = 38;
        if(arbol.busquedaNodo(valor, arbol.getRaiz())){
            
            System.out.println("\nEl valor " + valor + " ha sido encontrado.");
            
        }
        else{

            System.out.println("\nEl valor " + valor + " no ha sido encontrado.");
            
        }
        
        System.out.println("Eliminar valor 38");

        arbol.eliminarValor(38);
        
        arbol.arbolHorizontal(0, arbol.getRaiz());
        
    }
}