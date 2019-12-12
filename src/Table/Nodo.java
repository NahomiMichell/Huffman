package Table;

public class Nodo {

    private String Dato;
    private String Ubicacion;
    private Nodo Siguiente;

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public Nodo getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        Siguiente = siguiente;
    }

    public String getDato() {
        return Dato;
    }

    public void setDato(String dato) {
        Dato = dato;
    }

    public Nodo(String valor, String ub){
        this.setDato(valor);
        this.setSiguiente(null);
        this.setUbicacion(ub);
    }
}
