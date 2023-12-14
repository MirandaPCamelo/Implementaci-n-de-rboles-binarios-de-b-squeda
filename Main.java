/**
 * Main.
 * Llama a todos los métodos de la clase ABB.
 * 
 * @author (Miranda Patricia Pérez Camelo) 
 * @version (Diciembre 10, 2023)
 */
public class Main{
    public static void main(String[] args) {
        // Crear un objeto de la clase ABB
        ABB arbol = new ABB();
        //Nodo raizArbolPtr = arbol.getRaiz();

        //nodos en el árbol 9,2,1,16,6,11,8,4
        System.out.println("Insertando nodos en el árbol: 9,2,1,16,6,11,8,4");
        arbol.insertarValor(9); // Inserta el valor 9 en el árbol
        arbol.insertarValor(2); // Inserta el valor 2 en el árbol
        arbol.insertarValor(1); // Inserta el valor 1 en el árbol
        arbol.insertarValor(16); // Inserta el valor 16 en el árbol
        arbol.insertarValor(6); // Inserta el valor 6 en el árbol
        arbol.insertarValor(11); // Inserta el valor 11 en el árbol
        arbol.insertarValor(8); // Inserta el valor 8 en el árbol
        arbol.insertarValor(4); // Inserta el valor 4 en el árbol

        //Arbol horizontalmente
        System.out.println("Árbol horizontalmente");
        arbol.arbolHorizontal(0, arbol.getRaiz()); // Imprime el árbol horizontalmente

        //Recorridos en orden, preorden y postorden
        System.out.println("Recorrido en orden:");
        arbol.inorden(arbol.getRaiz()); // Imprime el recorrido en orden del árbol
        System.out.println("\nRecorrido en preorden:");
        arbol.preorden(arbol.getRaiz()); // Imprime el recorrido en preorden del árbol
        System.out.println("\nRecorrido en postorden:");
        arbol.postorden(arbol.getRaiz()); // Imprime el recorrido en postorden del árbol

        // Buscar un valor en el árbol
        int valorBuscado = 16;
        if(arbol.busqueda(valorBuscado, arbol.getRaiz())) // Busca el valor 16 en el árbol
        {
            System.out.println("\nEl valor " + valorBuscado + " se encuentra en el árbol.");
        }
        else
        {
            System.out.println("\nEl valor " + valorBuscado + " no se encuentra en el árbol.");
        }

        // Eliminar los nodos del árbol
        arbol.eliminarPredecesor(6,arbol.getRaiz()); // Elimina el predecesor del valor 6 en el árbol
        System.out.println("Se ha eliminado el predecesor del valor 6 en el árbol.");
        arbol.arbolHorizontal(0, arbol.getRaiz()); // Imprime el árbol horizontalmente
    }
}
