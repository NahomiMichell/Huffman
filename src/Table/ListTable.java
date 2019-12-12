package Table;

import Exceptions.EmptyList;

public class ListTable {
    private Nodo inicio;

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public ListTable(){
        inicio=null;
    }

    public void agregar(String valor,String ubicacion){
        Nodo nuevo=new Nodo(valor,ubicacion);
        if(this.getInicio() == null)
            this.setInicio(nuevo);
        else{
            nuevo.setSiguiente(inicio);
            inicio=nuevo;
        }
    }
    public Nodo sacarInicio() throws EmptyList {
        if(this.inicio==null)
            throw new EmptyList();
        Nodo aux=inicio;
        inicio=aux.getSiguiente();
        aux.setSiguiente(null);
        return aux;
    }

    public void imprimir(){
        if(this.getInicio()!=null){
            Nodo aux=inicio;
            while(aux!=null){
                System.out.println(aux.getDato()+":"+aux.getUbicacion());
                aux=aux.getSiguiente();
            }
        }
    }

    public String unirTodo(String mensaje) throws EmptyList {
        if(this.getInicio()==null)
            throw new EmptyList();
        String todo="";
        for(int i=0;i<mensaje.length();i++)
            todo=todo+ubicacionDe(mensaje.charAt(i)+"");
        return todo;
    }

    private String ubicacionDe(String dato){
        Nodo aux=inicio;
        while(aux!=null && !(aux.getDato().equals(dato))){
            aux=aux.getSiguiente();
        }
        return aux.getUbicacion();
    }

    public String LetraDe(String ubicacion){
        String letra=null;
        Nodo aux=inicio;
        while(aux!=null && !(aux.getUbicacion().equals(ubicacion))){
            aux=aux.getSiguiente();
        }
        if(aux!=null)
            letra=aux.getDato();
        return letra;
    }

}

