package ListTree;

import Exceptions.EmptyList;
import Exceptions.OutRank;
import ListChar.List;
import Table.ListTable;

public class ListArbol {
    private ListNodo inicio;
    public ListNodo getInicio() {
        return inicio;
    }
    public void setInicio(ListNodo inicio) {
        this.inicio = inicio;
    }

    public ListArbol(){
        inicio=null;
    }
    public void agregarOrdenados(Tree arbol){
        ListNodo nuevo=new ListNodo(arbol);
        if(inicio == null)
            inicio=nuevo;
        else{
            ListNodo aux=inicio;
            ListNodo aux2=null;
            while(aux != null && (aux.getArbol().getRaiz().getFrecuencia()<nuevo.getArbol().getRaiz().getFrecuencia())){
                aux2=aux;
                aux=aux.getSiguiente();
            }
            if(aux2==null){
                nuevo.setSiguiente(inicio);
                inicio=nuevo;
            }
            else
            if(aux==null)
                aux2.setSiguiente(nuevo);
            else{
                aux2.setSiguiente(nuevo);
                nuevo.setSiguiente(aux);
            }
        }
    }

    public void toLista(List l) throws EmptyList, OutRank {
        if(l.getInicio()==null)
            throw new EmptyList();
        else{
            String caracter="";
            Integer frecuencia=0;
            while(l.getInicio()!=null){
                caracter=l.getInicio().getDato()+"";
                frecuencia=l.contarIguales(l.getInicio().getDato());
                this.agregarOrdenados(new Tree(caracter,frecuencia));
                frecuencia=0;
                caracter="";
            }
        }
    }

    public void imprimir(){
        if(inicio==null)
            System.out.println("Null");
        else{
            ListNodo aux=inicio;
            System.out.print("Inicio --> ");
            while(aux!=null){
                System.out.print(aux.getArbol().getRaiz().getDato()+" : "+aux.getArbol().getRaiz().getFrecuencia()+"  -> ");
                aux=aux.getSiguiente();
            }
            System.out.print(" Null\n");
        }
    }

    public Nodo sacarInicio() throws EmptyList{
        if(this.inicio==null)
            throw new EmptyList();
        ListNodo aux=inicio;
        inicio=aux.getSiguiente();
        aux.setSiguiente(null);
        return aux.getArbol().getRaiz();
    }

    public void obtenerArbol() throws EmptyList {
        Nodo uno=null;
        Nodo dos=null;
        while(this.inicio.getSiguiente()!=null){
            uno=this.sacarInicio();
            dos=this.sacarInicio();
            Tree nuevo=new Tree(null,uno.getFrecuencia()+dos.getFrecuencia());
            nuevo.AgregarHojas(uno, dos);
            this.agregarOrdenados(nuevo);
        }
        System.out.println("Arbol creado.");
    }

    public ListTable obtenerHojas(String ubicacion, ListTable tabla, Nodo raiz){
        if(raiz.getDato()==null){
            tabla=obtenerHojas(ubicacion+"0",tabla,raiz.getIzq());
            tabla=obtenerHojas(ubicacion+"1",tabla,raiz.getDer());
        }
        else
            tabla.agregar(raiz.getDato(), ubicacion);
        return tabla;
    }
}
