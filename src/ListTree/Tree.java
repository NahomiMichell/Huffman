package ListTree;

public class Tree {
    private Nodo raiz;

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Tree(){
        raiz=null;
    }

    public Tree(String s,Integer suma){
        raiz=new Nodo(s,suma);
    }

    public void AgregarHojas(Nodo izq,Nodo der){
        raiz.setIzq(izq);
        raiz.setDer(der);
    }
}
