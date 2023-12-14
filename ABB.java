/**
 * Árbol Binario de Búsqueda (ABB).
 * Un ABB es una estructura de datos en la que cada nodo tiene un valor y dos subárboles,
 * uno a la izquierda con valores menores y otro a la derecha con valores mayores.
 * 
 * @author (Miranda Patricia Pérez Camelo) 
 * @version (Diciembre 10, 2023)
 */
public class ABB
{
    private Node raiz; // Nodo raíz del árbol

    /**
     * Crea un nuevo ABB vacío.
     */
    ABB()
    {
        this.raiz = null; // Inicializa la raíz como nula
    } 

    /**
     * Verifica si el ABB está vacío.
     * @return true si el ABB está vacío, false de lo contrario.
     */
    public boolean esVacio()
    {
        return (this.raiz == null); // Retorna true si la raíz es nula, false de lo contrario
    }

    /**
     * Obtiene la raíz del ABB.
     * @return la raíz del ABB.
     */
    public Node getRaiz()
    {
        return this.raiz; // Retorna la raíz del árbol
    }

    /**
     * Inserta un nuevo valor en el ABB.
     * @param valor el valor a insertar.
     */
    public void insertarValor(int valor)
    {
        if (this.raiz == null)
        {
            System.out.println("Insertando raiz: " + valor);
            this.raiz = new Node(); // Crea un nuevo nodo
            this.raiz.name = valor; // Asigna el valor al nodo raíz
            this.raiz.izquierdo = null; // Inicializa el subárbol izquierdo como nulo
            this.raiz.derecho = null; // Inicializa el subárbol derecho como nulo
        }
        else 
        {
            insertarNodo(valor, this.raiz); // Llama al método insertarNodo para insertar el valor en el árbol
        }
    }

    /**
     * Inserta un nuevo nodo en el ABB.
     * @param valor el valor del nodo a insertar.
     * @param nodoA el nodo actual en el que se está insertando.
     */
    public void insertarNodo(int valor, Node nodoA)
    {
        if (valor <= nodoA.name) //si el valor es igual o menor al valor del nodo
        {
            if (nodoA.izquierdo == null) //si el hijo izquierdo es null
            {
                System.out.println("Insertando hijo izquierdo de: "  + nodoA.name + ": " + valor); //se inserta el nombre del nodo y su valor
                nodoA.izquierdo =  new Node(); // Crea un nuevo nodo
                nodoA.izquierdo.name = valor; // Asigna el valor al nodo izquierdo
                nodoA.izquierdo.izquierdo = null; // Inicializa el subárbol izquierdo del nodo izquierdo como nulo
                nodoA.izquierdo.derecho = null; // Inicializa el subárbol derecho del nodo izquierdo como nulo
            }
            else 
            {
                insertarNodo(valor, nodoA.izquierdo); // Llama recursivamente al método insertarNodo para insertar el valor en el subárbol izquierdo
            }
        }
        else 
        {
            if (valor > nodoA.name) //si valor es mayor al valor del nodo
            {
                if (nodoA.derecho == null) 
                {
                    System.out.println("Insert hijo derecho de: " + nodoA.name + ": " + valor); //se inserta el nombre del nodo y su valor
                    nodoA.derecho =  new Node(); // Crea un nuevo nodo
                    nodoA.derecho.name = valor; // Asigna el valor al nodo derecho
                    nodoA.derecho.izquierdo = null; // Inicializa el subárbol izquierdo del nodo derecho como nulo
                    nodoA.derecho.derecho = null; // Inicializa el subárbol derecho del nodo derecho como nulo
                }
                else 
                {
                    insertarNodo(valor, nodoA.derecho); // Llama recursivamente al método insertarNodo para insertar el valor en el subárbol derecho
                }
            }
        }
    }

    /**
     * Imprime el ABB en forma horizontal.
     * @param nivel el nivel actual del nodo.
     * @param nodoA el nodo actual.
     */
    public void arbolHorizontal(int nivel, Node nodoA)
    {
        if(nodoA == null)
        {
            return; 
        }
        else
        {
            arbolHorizontal(nivel + 1, nodoA.derecho); // Llama recursivamente al método arbolHorizontal para imprimir el subárbol derecho

            for(int i=0; i < nivel; i++)
            {
                System.out.print("   "); // Imprime espacios en blanco para representar la indentación del nivel del nodo
            }

            System.out.println("["+ nodoA.name + "]"); // Imprime el valor del nodo actual
            arbolHorizontal(nivel + 1,nodoA.izquierdo); // Llama recursivamente al método arbolHorizontal para imprimir el subárbol izquierdo
        }
    }

    /**
     * Realiza un recorrido inorden del ABB.
     * @param nodoA el nodo actual.
     * inorden: izq, raíz, der
     */
    public void inorden(Node nodoA)
    {
        if(nodoA == null)
        {
            return; 
        }
        
        inorden(nodoA.izquierdo); // Llama recursivamente al método inorden para recorrer el subárbol izquierdo
        System.out.print(nodoA.name + " - "); // Imprime el valor del nodo actual
        inorden(nodoA.derecho); // Llama recursivamente al método inorden para recorrer el subárbol derecho
    }

    /**
     * Realiza un recorrido preorden del ABB.
     * @param nodoA el nodo actual.
     * preorden: raíz, izq, der
     */
    public void preorden(Node nodoA)
    {
        if(nodoA == null)
        {
            return;
        }
        
        System.out.print(nodoA.name + " - "); // Imprime el valor del nodo actual
        preorden(nodoA.izquierdo); // Llama recursivamente al método preorden para recorrer el subárbol izquierdo
        preorden(nodoA.derecho); // Llama recursivamente al método preorden para recorrer el subárbol derecho
    }

    /**
     * Realiza un recorrido postorden del ABB.
     * @param nodoA el nodo actual.
     * izq, der, raíz
     */
    public void postorden(Node nodoA)
    {
        if(nodoA==null)
        {
            return;
        }
        
        postorden(nodoA.izquierdo); // Llama recursivamente al método postorden para recorrer el subárbol izquierdo
        postorden(nodoA.derecho); // Llama recursivamente al método postorden para recorrer el subárbol derecho
        System.out.print(nodoA.name + " - "); // Imprime el valor del nodo actual
    }

    /**
     * Busca un valor en el ABB.
     * @param x el valor a buscar.
     * @param nodoA el nodo actual.
     * @return true si el valor se encuentra en el ABB, false de lo contrario.
     */
    public boolean busqueda(int x, Node nodoA)
    {
        if (nodoA == null)
        {
            return false;
        }
        else 
        {
            if(x < nodoA.name)
            {
                return busqueda(x,nodoA.izquierdo); // Llama recursivamente al método busqueda para buscar el valor en el subárbol izquierdo
            }
            else 
            {
                if (x > nodoA.name)
                {
                    return busqueda(x,nodoA.derecho); // Llama recursivamente al método busqueda para buscar el valor en el subárbol derecho
                }
                else
                {
                    return true; // Retorna true si el valor se encuentra en el nodo actual
                }
            }
        }
    }

    /**
     * Corta el ABB, eliminando todos los nodos.
     * @param nodoA el nodo actual.
     */
    public void CortarArbol(Node nodoA)
    {
        if(nodoA == null)
        {
            return;
        }

        //Se elimina el subnodoRef izquierdo
        CortarArbol(nodoA.izquierdo); // Llama recursivamente al método CortarArbol para eliminar el subárbol izquierdo
        //Se elimina el subnodoRef derecho
        CortarArbol(nodoA.derecho); // Llama recursivamente al método CortarArbol para eliminar el subárbol derecho
        //Se elimina el nodo actual
        nodoA = null; // Asigna nulo al nodo actual
    }

    /**
     * Busca el nodo con el valor mayor en el ABB.
     * @param nodoA el nodo actual.
     * @return el nodo con el valor mayor.
     */
    public Node buscaMayor(Node nodoA) 
    {
        if (nodoA == null) 
        {
            return null;
        } 
        else 
        {
            if (nodoA.derecho == null)
            {
                return nodoA; // Retorna el nodo actual si no tiene subárbol derecho
            }
            else
            {
                return buscaMayor(nodoA.derecho); // Llama recursivamente al método buscaMayor para buscar el nodo con el valor mayor en el subárbol derecho
            }
        }
    }

    /**
     * Elimina un nodo predecesor en el ABB.
     * @param x el valor del nodo predecesor a eliminar.
     * @param nodoA el nodo actual.
     */
    public void eliminarPredecesor(int x, Node nodoA) {
        if (nodoA == null)
        {
            return;
        } 
        else
        {
            if (x < nodoA.name)
            {
                eliminarPredecesor(x, nodoA.izquierdo); // Llama recursivamente al método eliminarPredecesor para eliminar el nodo predecesor en el subárbol izquierdo
            }
            else
            {
                if (x > nodoA.name)
                {
                    eliminarPredecesor(x, nodoA.derecho); // Llama recursivamente al método eliminarPredecesor para eliminar el nodo predecesor en el subárbol derecho
                }
                else
                {
                    if (nodoA.izquierdo != null && nodoA.derecho != null)
                    {
                        Node mayor = buscaMayor(nodoA.izquierdo); // Busca el nodo con el valor mayor en el subárbol izquierdo
                        nodoA.name = mayor.name; // Asigna el valor del nodo mayor al nodo actual
                        eliminarPredecesor(mayor.name, nodoA.izquierdo); // Llama recursivamente al método eliminarPredecesor para eliminar el nodo mayor en el subárbol
                    }
                    else
                    {
                        if (nodoA.izquierdo == null)
                        {
                            nodoA = nodoA.derecho; // Asigna el subárbol derecho al nodo actual
                        }
                        else
                        {
                            if (nodoA.derecho == null)
                            {
                                nodoA = nodoA.izquierdo; // Asigna el subárbol izquierdo al nodo actual
                            }
                        }
                    }
                }
            }
        }
    }
}
