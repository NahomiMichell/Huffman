package Exceptions;

public class EmptyList extends Exception{

    private static final long serialVersionUID = 1l;

    public EmptyList(){
        System.out.println("Error, La lista esta vacia");
    }
}
