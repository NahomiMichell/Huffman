package Exceptions;

public class OutRank extends Exception {
    private static final long serialVersionUID = 1l;

    public OutRank(){
        System.out.println("Fuera de Rango. Verifique la posicion");
    }
}
