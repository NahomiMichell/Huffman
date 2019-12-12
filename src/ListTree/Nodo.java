package ListTree;

public class Nodo {
    private String dato;
    private Integer frecuencia;
    private Nodo izq;
    private Nodo der;

    public Integer getFrecuencia() {
        return frecuencia;
    }
    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }
    public String getDato() {
        return dato;
    }
    public void setDato(String dato) {
        this.dato = dato;
    }
    public Nodo getIzq() {
        return izq;
    }
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
    public Nodo getDer() {
        return der;
    }
    public void setDer(Nodo der) {
        this.der = der;
    }

    public Nodo(String d){
        dato=d;
        frecuencia=1;
        izq=null;
        der=null;
    }
    public Nodo(String d,Integer n){
        dato=d;
        frecuencia=n;
        izq=null;
        der=null;
    }
}
