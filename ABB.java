public class ABB{
    
    private Nodo raiz;
    
    ABB(){
        this.raiz = null;
    } 
 
    public boolean esVacio(){
        return (this.raiz == null); 
    }
  
    public Nodo getRaiz(){
        return this.raiz;
    }
 
    public void insertarValor(int valor){
        if (this.raiz == null){
            System.out.println("Insertando raiz: " + valor);
            this.raiz = new Nodo();
            this.raiz.dato = valor;
            this.raiz.izquierdo = null;
            this.raiz.derecho = null;
        }
        else insertarNodo(valor, this.raiz);
    }

    public void insertarNodo(int valor, Nodo nodoRef){
        if (valor <= nodoRef.dato) {
            if (nodoRef.izquierdo == null){
                System.out.println("Insertando hijo izquierdo de: "  + nodoRef.dato + ": " + valor);
                nodoRef.izquierdo =  new Nodo();
                nodoRef.izquierdo.dato = valor;
                nodoRef.izquierdo.izquierdo = null;
                nodoRef.izquierdo.derecho = null;
            }
            else {
                insertarNodo(valor, nodoRef.izquierdo);
            }
        }
        else {
            if (valor > nodoRef.dato) {
                if (nodoRef.derecho == null){
                    System.out.println("Insertando hijo derecho de: " + nodoRef.dato + ": " + valor);
                    nodoRef.derecho =  new Nodo();
                    nodoRef.derecho.dato = valor;
                    nodoRef.derecho.izquierdo = null;
                    nodoRef.derecho.derecho = null;
                }
                else {
                    insertarNodo(valor, nodoRef.derecho);
                }
            }
        }
    }

    public void arbolHorizontal(int nivel, Nodo nodoRef){
        if(nodoRef == null){
            return; 
        }
        else{

            arbolHorizontal(nivel + 1, nodoRef.derecho);

            for(int i=0;i<nivel;i++){
                System.out.print("   ");
            }

            System.out.println("["+ nodoRef.dato + "]");
            arbolHorizontal(nivel + 1, nodoRef.izquierdo);
        }
    }
   
    public boolean busquedaNodo(int x, Nodo nodoRef){
        if (nodoRef==null)
            return false;
        else if(x<nodoRef.dato)
            return busquedaNodo(x,nodoRef.izquierdo);
        else if(x>nodoRef.dato)
            return busquedaNodo(x,nodoRef.derecho);
        else 
            return true; 
    }

    
    public void preOrden(Nodo nodoRef){
        if(nodoRef==null)
            return; 
        System.out.print(nodoRef.dato + " - ");
        preOrden(nodoRef.izquierdo);
        preOrden(nodoRef.derecho);
    }

    public void inOrden(Nodo nodoRef){
        if(nodoRef==null)
            return; 
        inOrden(nodoRef.izquierdo);
        System.out.print(nodoRef.dato + " - ");
        inOrden(nodoRef.derecho);
    }

    public void postOrden(Nodo nodoRef){
        if(nodoRef==null)
            return; 
        postOrden(nodoRef.izquierdo);
        postOrden(nodoRef.derecho);
        System.out.print(nodoRef.dato + " - ");
    }

    
    public void eliminarValor(int valor) {
        raiz = eliminarNodo(raiz, valor);
    }

    private Nodo eliminarNodo(Nodo raiz, int valor) {
        if (raiz == null) {
            return raiz;
        }

        if (valor < raiz.dato) {
            raiz.izquierdo = eliminarNodo(raiz.izquierdo, valor);
        } else if (valor > raiz.dato) {
            raiz.derecho = eliminarNodo(raiz.derecho, valor);
        } else {
            if (raiz.izquierdo == null) {
                return raiz.derecho;
            } else if (raiz.derecho == null) {
                return raiz.izquierdo;
            }

            raiz.dato = minimoValor(raiz.derecho);

            raiz.derecho = eliminarNodo(raiz.derecho, raiz.dato);
        }

        return raiz;
    }
 
    private int minimoValor(Nodo raiz) {
        int minv = raiz.dato;
        while (raiz.izquierdo != null) {
            minv = raiz.izquierdo.dato;
            raiz = raiz.izquierdo;
        }
        return minv;
    }
    
}