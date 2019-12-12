package Principal;

import Exceptions.EmptyList;
import Exceptions.NullName;
import Exceptions.OutRank;
import ListChar.List;
import ListTree.ListArbol;
import Table.ListTable;
import Table.Nodo;

import java.io.*;
import java.util.Scanner;
import java.io.IOException;


public class TextCompressor {
    Scanner SC=new Scanner(System.in);
    public String[] Comprimir(String mensaje) throws OutRank, EmptyList, IOException, NullName, ClassNotFoundException {

        List cadena=new List();
        cadena.toLista(mensaje);
        cadena.recorrer();


        ListArbol lista=new ListArbol();
        lista.toLista(cadena);
        lista.imprimir();

        lista.obtenerArbol();

        ListTable tabla=new ListTable();
        tabla=lista.obtenerHojas("", tabla, lista.getInicio().getArbol().getRaiz());

        String direcciones=tabla.unirTodo(mensaje);

        System.out.println("Escribir el nombre del archivo a generar: ");
        String archivo = SC.next();
        if(archivo.length()==0){
            System.out.println("Error, ese nombre no es valido. Intenta de nuevo.");
            throw new NullName();
        }

        String codificado=escribir(direcciones,tabla,archivo+".txt");

        String[] array={direcciones,codificado};
        return array;
    }
    public String Descomprimir() throws NullName, IOException {

        Scanner s = new Scanner(System.in);
        System.out.println("Mombre del archivo a descomprimir");
        String a = s.next();

        File doc = new File(a + ".txt");
        FileReader fr = new FileReader(doc);
        BufferedReader lector = new BufferedReader(fr);
        String apoyo2 = lector.readLine();
        Integer falta = Integer.parseInt(lector.readLine());
        String apoyo = "";
        String mensaje = "";
        byte bit2;

        for (int i = 0; i < apoyo2.length(); i++) {
            bit2 = (byte) apoyo2.charAt(i);
            apoyo = Integer.toBinaryString(bit2 & 0xFF);
            if (apoyo.length() < 8) {
                apoyo = rellenar(apoyo);
                if (i == (apoyo2.length() - 1))
                    apoyo = quitar(apoyo, falta);
            }
            mensaje += apoyo;
        }

        ListTable tabla = new ListTable();
        apoyo = lector.readLine();
        while (apoyo != null) {
            tabla.agregar(apoyo.charAt(0) + "", quitar(apoyo, 1));
            apoyo = lector.readLine();
        }
        System.out.println("Archivo cargado con exito");
        apoyo = "";
        String original = "";
        apoyo2 = "";

        for (int i = 0; i < mensaje.length(); i++) {
            apoyo = apoyo + mensaje.charAt(i);
            apoyo2 = tabla.LetraDe(apoyo);
            if (apoyo2 != null) {
                original = original + apoyo2;
                apoyo = "";
                apoyo2 = "";
            }
        }
        return original;
    }



    private String escribir(String mensaje,ListTable tabla,String nombre) throws ClassNotFoundException, IOException{
        File f=new File(nombre);
        FileWriter NuevaFila=new FileWriter(f);
        BufferedWriter ProcteccionEscritura=new BufferedWriter(NuevaFila);
        PrintWriter escritor=new PrintWriter(ProcteccionEscritura);
        String bits="";
        String codificado="";
        int falta=0;
        byte bin;
        char car;

        for(int i=0;i<mensaje.length();i++){
            if(bits.length()==8){
                bin = (byte)Short.parseShort(bits, 2);
                car=(char)(bin & 0xFF);
                codificado+=car;
                bits="";
                i--;
            }else
                bits+=mensaje.charAt(i);
        }
        if(bits.length()!=0){
            bin = (byte)Short.parseShort(bits, 2);
            car=(char)(bin & 0xFF);
            codificado+=car;
            falta=8-bits.length();
        }

        escritor.write(codificado+"\n");
        escritor.write(falta+"\n");
        Nodo aux=tabla.getInicio();

        while(aux!=null){
            escritor.write(aux.getDato()+aux.getUbicacion()+"\n");
            aux=aux.getSiguiente();
        }
        escritor.close();
        ProcteccionEscritura.close();
        System.out.println( "Su archivo ha sido creado exitosamente!! \n nombre: "+nombre);

        return codificado;
    }
    public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }

    private String rellenar(String cadena){
        String nueva="";
        for(int i=0;i<8-cadena.length();i++){
            nueva+="0";
        }
        nueva+=cadena;
        return nueva;
    }

    private String quitar(String cad,Integer n){
        String nueva="";
        for(int i=n;i<cad.length();i++)
            nueva+=cad.charAt(i);
        return nueva;
    }
}
