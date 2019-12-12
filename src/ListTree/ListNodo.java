package ListTree;

public class ListNodo {
    private Tree arbol;
    private ListNodo Siguiente;

    public Tree getArbol() {
        return arbol;
    }
    public void setArbol(Tree arbol) {
        this.arbol = arbol;
    }
    public ListNodo getSiguiente() {
        return Siguiente;
    }
    public void setSiguiente(ListNodo siguiente) {
        Siguiente = siguiente;
    }

    public ListNodo(Tree valor){
        this.setArbol(valor);
        this.setSiguiente(null);
    }
}
