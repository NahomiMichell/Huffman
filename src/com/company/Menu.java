package com.company;

public class Menu {
    public int menu(){
        System.out.println("");
        System.out.println("");
        System.out.println("----------------------Menu Principal----------------------");
        System.out.println("1. Comprimir archivo");
        System.out.println("2. Descomprimir archivo");
        System.out.println("3. Salir");

        int opcion = 0;

        while((opcion <1)|| (opcion>4)){
            KeyboardReader KBR = new KeyboardReader();
            opcion = KBR.leerEntero("Ingrese una opcion","Error, por favor intente de nuevo");

            if ((opcion<1)||(opcion>6)){
                System.out.println("Esta opcion no es valida, asegurese de elegir una opcion que este en el menu");
            }
        }
        return opcion;
    }
}
